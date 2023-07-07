package com.example.cinemamovietickets.viewmodels.booking

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cinemamovietickets.data.datasource.local.fake.MoviesData
import com.example.cinemamovietickets.ui.screens.booking.BookingArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(BookingUIState())
    val state = _state.asStateFlow()

    private val args = BookingArgs(savedStateHandle)

    init {
        _state.update { state ->
            state.copy(
                imageId = args.imageId.toString().toInt(),
                image = "${
                    MoviesData.newShowingMovies().find {
                        it.id == args.imageId.toString().toInt()
                    }?.imageUrl
                }"
            )
        }
    }
}