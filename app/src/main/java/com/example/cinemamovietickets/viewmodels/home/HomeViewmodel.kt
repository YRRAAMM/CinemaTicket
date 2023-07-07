package com.example.cinemamovietickets.viewmodels.home

import androidx.lifecycle.ViewModel
import com.example.cinemamovietickets.data.datasource.local.fake.MoviesData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.lang.Exception
import javax.inject.Inject

// todo apply dI and add domain layer

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeUIState())
    val state = _state.asStateFlow()

    init {
        getMovies()
    }

    private fun getMovies() {
        _state.update { it.copy(isLoading = true) }
        try {
            _state.update { it.copy(movies = MoviesData.newShowingMovies(), isLoading = false) }
        } catch (e : Exception) {
            _state.update { it.copy(error = true, isLoading = false) }
        }
    }


}