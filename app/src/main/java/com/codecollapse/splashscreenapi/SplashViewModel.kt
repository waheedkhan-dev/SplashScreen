package com.codecollapse.splashscreenapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _splashFakeApiResponse = MutableStateFlow(false)
    val splashFakeApiResponse = _splashFakeApiResponse.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            delay(2000)
            _splashFakeApiResponse.value = true
        }
    }
}