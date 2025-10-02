package com.example.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.extensions.toActionState
import com.example.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {
    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState: StateFlow<HomeViewState> = _viewState

    fun updateOtherText() {
        _viewState.update {
            it.copy(otherText = "testStringUpdated")
        }
    }

    fun getPopularMovies() {
        _viewState.update {
            it.copy(popularMovies = it.popularMovies.copy(isLoading = true))
        }
        viewModelScope.launch {
            val result = getPopularMoviesUseCase()
            _viewState.update {
                it.copy(popularMovies = result.toActionState())
            }
        }
    }

    init {
        getPopularMovies()
    }
}