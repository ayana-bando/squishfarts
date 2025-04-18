package com.bando.android.squishfarts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bando.android.squishfarts.data.SquishFartRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

//TODO - add doc
class SquishFartViewModel @Inject constructor(private val squishFartRepo: SquishFartRepository) : ViewModel() {
    // TODO - build out get sound effects function
    private fun getSoundEffects() {
        viewModelScope.launch {

        }
    }
}