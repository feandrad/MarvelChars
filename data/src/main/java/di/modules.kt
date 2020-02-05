package io.felipeandrade.marvelchars.data.di

import io.felipeandrade.marvelchars.data.characters.CharacterApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
