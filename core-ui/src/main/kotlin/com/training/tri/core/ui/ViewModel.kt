package com.training.tri.core.ui

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
abstract class ViewModel<ViewState : Any, Action : Any>(
    initialState: ViewState,
    val update: (ViewState, Action) -> ViewState
) {

    private val stateFlow = MutableStateFlow(initialState)

    var enableLogs = false

    fun dispatch(action: Action) {
        val newState = update(stateFlow.value, action)
        // TODO if enable logs, Timber out here
        stateFlow.value = newState
    }

    fun dispatch(vararg actions: Action) {
        actions.forEach { action ->
            dispatch(action)
        }
    }

    fun observe(): Flow<ViewState> = stateFlow
}