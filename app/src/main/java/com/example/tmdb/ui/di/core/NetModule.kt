package com.example.tmdb.ui.di.core

import com.example.tmdb.data.api.TMDBService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String, private val apiKey: String) {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder().addInterceptor { chain ->
                    val url =
                        chain.request().url.newBuilder().addQueryParameter("api_key", apiKey).build()
                    chain.proceed(chain.request().newBuilder().url(url).build())
                }.build()
            )
            .build()

    @Singleton
    @Provides
    fun provideTMDBServie(retrofit: Retrofit): TMDBService =
        retrofit.create(TMDBService::class.java)
}