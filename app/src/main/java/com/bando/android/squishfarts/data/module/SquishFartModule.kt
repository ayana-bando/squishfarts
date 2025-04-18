package com.bando.android.squishfarts.data.module

import com.bando.android.squishfarts.data.datasource.FreesoundService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

private const val BASE_URL = "https://freesound.org/apiv2/"
//TODO add docs
@Module
@InstallIn(SingletonComponent::class)
object SquishFartModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()

    @Provides
    @Singleton
    fun provideFreeSoundService(retrofit: Retrofit) =
        retrofit.create(FreesoundService::class.java)
}