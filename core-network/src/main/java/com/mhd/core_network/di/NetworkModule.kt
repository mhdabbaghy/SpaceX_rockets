package com.mhd.core_network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mhd.core_network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
        return builder.build()
    }

    @Provides
    fun provideClient(interceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(interceptor)
        return builder.build()
    }

    @Provides
    fun provideLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

}