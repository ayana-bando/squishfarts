package com.bando.android.squishfarts.data.datasource

/**
 * @author Ayana Bando
 * Date 04/18/2025
 */

import com.bando.android.squishfarts.data.SoundEffects
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interface for Freesound [data](https://freesound.org/docs/api/resources_apiv2.html)
 *
 * Note: sound_id and duration are number values that will be converted when in use
 */
interface FreesoundService {
    /**
     * Gets sound data needed throughout app
     * @param soundId [String] Sound's unique ID
     * @param category [Array]<[String]> Two-element array containing sound's category and subcategory names
     * @param duration [String] Duration of sound in seconds
     */
    @Headers("Accept: application/json")
    @GET("sounds/{sound_id}/search?")
    suspend fun getSoundEffects(
        @Path("sound_id") soundId: String,
        @Query("category") category: Array<String>,
        @Query("duration") duration: String? = null
    ): Response<List<SoundEffects>>
}