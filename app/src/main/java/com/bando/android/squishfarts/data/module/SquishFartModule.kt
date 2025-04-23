package com.bando.android.squishfarts.data.module

import com.bando.android.squishfarts.BuildConfig
import com.bando.android.squishfarts.data.datasource.FreesoundService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://freesound.org/apiv2/"
private val API_KEY = BuildConfig.FREESOUND_API_KEY
//TODO add docs
@Module
@InstallIn(SingletonComponent::class)
object SquishFartModule {
    private fun okHttpClient() = OkHttpClient.Builder()
        .addInterceptor(Interceptor { chain ->
            val request: Request = chain.request()
                .newBuilder()
                .header("accept", "application/json")
                .header("Authorization", " Token $API_KEY")
                .build()
            chain.proceed(request)
        })

    @Provides
    @Singleton
    fun provideFreesoundService(): FreesoundService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FreesoundService::class.java)
}