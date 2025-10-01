package com.example.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.extensions.toActionState
import com.example.domain.usecase.GetExamplesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(private val getExamplesUseCase: GetExamplesUseCase) : ViewModel() {
    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState: StateFlow<HomeViewState> = _viewState

    fun getExamples() {
        _viewState.update {
            it.copy(examples = it.examples.copy(isLoading = true))
        }
        viewModelScope.launch {
            val result = getExamplesUseCase()
            _viewState.update {
                it.copy(examples = result.toActionState())
            }
        }
    }

    fun updateOtherText() {
        _viewState.update {
            it.copy(otherText = "testStringUpdated")
        }
    }
}