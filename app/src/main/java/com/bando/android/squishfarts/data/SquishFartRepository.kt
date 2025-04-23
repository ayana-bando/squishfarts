package com.bando.android.squishfarts.data

import com.bando.android.squishfarts.data.datasource.FreesoundService
import retrofit2.Response
import javax.inject.Inject

// TODO-add docs
interface SquishFartRepository {
    suspend fun getSoundEffects(soundId: String, category: Array<String>): Response<List<SoundEffects>>
}

class SquishFartRepositoryImpl @Inject constructor(private val freesoundService: FreesoundService) : SquishFartRepository {
    override suspend fun getSoundEffects(soundId: String, category: Array<String>): Response<List<SoundEffects>> {
        return freesoundService.getSoundEffects(soundId, category)
    }
}