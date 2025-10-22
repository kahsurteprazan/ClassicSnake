package com.example.classicsnake.ui.base.archtectur

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel <Event: UiEvent, State: UiState, Action: UiAction> (initialState: State): ViewModel() {

    // доступ только внутри BaseViewModel
    private val _viewState = MutableStateFlow(initialState)

    // доступ в классах-наследниках
    protected var viewState: State
        get() = _viewState.value // при обращении к полю получаем актуальное значение из _viewState
        set(value) { // при обновлении значения записываем его в _viewState
            _viewState.value = value
        }

    private val actionsChannel = Channel<Action>(capacity = Channel.CONFLATED)

    protected fun sideEffect(action: Action) {
        actionsChannel.trySend(action)
    }

    fun viewActions(): Flow<Action?> = actionsChannel.receiveAsFlow()
    fun viewStates(): StateFlow<State> = _viewState.asStateFlow()

    abstract fun obtainEvent(event: Event)
}