// com/jorgromo/androidClassMp1/secondpartial/home/viewmodel/HomeViewModel.kt

package com.jorgeromo.androidClassMp1.secondpartial.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgeromo.androidClassMp1.secondpartial.home.model.HomeSection
import com.jorgeromo.androidClassMp1.secondpartial.home.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class HomeViewModel : ViewModel() {

    private val _homeSections = MutableStateFlow<List<HomeSection>>(emptyList())
    val homeSections: StateFlow<List<HomeSection>> = _homeSections

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        fetchHomeData()
    }

    private fun fetchHomeData() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getHomeScreenData()
                _homeSections.value = response.homeScreen
            } catch (e: IOException) {
                _errorMessage.value = "Error de red: ${e.message}"
            } catch (e: Exception) {
                _errorMessage.value = "Ocurrió un error: ${e.message}"
            }
        }
    }
}