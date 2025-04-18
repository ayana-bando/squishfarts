package com.bando.android.squishfarts.data

import com.bando.android.squishfarts.data.datasource.FreesoundService
import retrofit2.Response
import javax.inject.Inject
// TODO-add docs
interface SquishFartRepository {
    suspend fun getSoundEffects(): Response<List<SoundEffects>>
}

class NetworkSquishFartRepository @Inject constructor(private val freesoundService: FreesoundService) : SquishFartRepository {
    override suspend fun getSoundEffects(): Response<List<SoundEffects>> {
        return freesoundService.getSoundEffects("",arrayOf(""),"")
    }
}