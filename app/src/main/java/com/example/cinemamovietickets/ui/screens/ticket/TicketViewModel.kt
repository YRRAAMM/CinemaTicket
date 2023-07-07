package com.example.cinemamovietickets.ui.screens.ticket

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cinemamovietickets.data.datasource.local.fake.MoviesData
import com.example.cinemamovietickets.viewmodels.ticket.uistate.TicketUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TicketViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = MutableStateFlow(TicketUIState())
    val state = _state.asStateFlow()

    private val args = TicketArgs(savedStateHandle)

    init {
        _state.update { state ->
            state.copy(
                image = "${
                    MoviesData.newShowingMovies().find {
                        it.id == args.imageId.toString().toInt()
                    }?.imageUrl
                }"
            )
        }
    }

}