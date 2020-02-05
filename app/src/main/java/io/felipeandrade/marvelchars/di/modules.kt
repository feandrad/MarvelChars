package io.felipeandrade.marvelchars.di

import io.felipeandrade.marvelchars.data.CharacterRepository
import io.felipeandrade.marvelchars.data.characters.CharacterApi
import io.felipeandrade.marvelchars.ui.characters.CharSelectionAdapter
import io.felipeandrade.marvelchars.ui.characters.CharSelectionViewModel
import io.felipeandrade.marvelchars.usecases.LoadCharacterById
import io.felipeandrade.marvelchars.usecases.LoadCharactersUseCase
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val coreModule = module(override = true) {

    single { AuthInterceptor() }
    single { provideOkHttpClient(get()) }
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


val API_URL = "https://gateway.marvel.com/"
val API_ID = "MarvelChar"
val API_KEY = "9ff509f0c2ceab09daf08c8e4632c132"


fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideCharacterApi(retrofit: Retrofit): CharacterApi =
    retrofit.create(CharacterApi::class.java)

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        // DONT INCLUDE API KEYS IN YOUR SOURCE CODE
        val url = req.url().newBuilder().addQueryParameter(API_ID, API_KEY).build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}
