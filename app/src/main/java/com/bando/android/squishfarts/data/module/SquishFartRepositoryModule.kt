package com.bando.android.squishfarts.data.module

import com.bando.android.squishfarts.data.SoundEffects
import com.bando.android.squishfarts.data.SquishFartRepository
import com.bando.android.squishfarts.data.datasource.FreesoundService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class SquishFartRepositoryImpl @Inject constructor(private val freesoundService: FreesoundService) : SquishFartRepository{
    override suspend fun getSoundEffects(): Response<List<SoundEffects>> {
        return freesoundService.getSoundEffects("", arrayOf(""),"")
    }

}
@Module
@InstallIn(SingletonComponent::class)
abstract class SquishFartRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindSquishFartRepository(squishFartRepositoryImpl: SquishFartRepositoryImpl): SquishFartRepositoryImpl
}