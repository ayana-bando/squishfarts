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
    @GET("{sound_id}/")
    suspend fun getSoundEffects(
        @Path("sound_id") soundId: String,
    ): Response<SoundEffects>
}