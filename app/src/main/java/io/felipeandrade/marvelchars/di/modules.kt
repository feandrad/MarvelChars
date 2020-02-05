package io.felipeandrade.marvelchars.di

import io.felipeandrade.marvelchars.data.BuildConfig
import io.felipeandrade.marvelchars.data.CharacterRepository
import io.felipeandrade.marvelchars.data.characters.CharacterApi
import io.felipeandrade.marvelchars.ui.characters.CharSelectionAdapter
import io.felipeandrade.marvelchars.ui.characters.CharSelectionViewModel
import io.felipeandrade.marvelchars.usecases.LoadCharacterById
import io.felipeandrade.marvelchars.usecases.LoadCharactersUseCase
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val coreModule = module(override = true) {
    single { createOkHttpClient() }
    single { provideCharacterApi(get()) }
    single { provideRetrofit(get()) }
}

val characterModule = module(override = true) {
    factory { CharSelectionAdapter() }
    viewModel { CharSelectionViewModel(get()) }

    single { LoadCharactersUseCase(get()) }
    single { LoadCharacterById(get()) }
    single { CharacterRepository(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun provideCharacterApi(retrofit: Retrofit): CharacterApi =
    retrofit.create(CharacterApi::class.java)

