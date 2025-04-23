package com.bando.android.squishfarts.data.module

import com.bando.android.squishfarts.data.SquishFartRepository
import com.bando.android.squishfarts.data.SquishFartRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SquishFartRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindSquishFartRepository(squishFartRepository: SquishFartRepositoryImpl): SquishFartRepository

}
