package com.bando.android.squishfarts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bando.android.squishfarts.data.SoundEffects
import com.bando.android.squishfarts.data.SquishFartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.logging.Level
import java.util.logging.Logger
import javax.inject.Inject

//TODO - add doc
@HiltViewModel
class SquishFartViewModel @Inject constructor(private val squishFartRepo: SquishFartRepository) : ViewModel() {
    var soundEffects = MutableStateFlow(mutableListOf<SoundEffects>())

    fun getSoundEffects(soundId: String) {
        // Create a Logger
        val logger = Logger.getLogger(
            SquishFartViewModel::class.java.getName()
        )

        viewModelScope.launch(Dispatchers.Main) {
            val response = squishFartRepo.getSoundEffects(soundId)
            if(response.isSuccessful) {
               response.body()?.let { soundEffects.value.add(it) }
            } else {
                logger.log(Level.SEVERE, "$response.code() $response.message()")
            }
        }
    }
}