package com.training.tri.workout.ui

import com.training.tri.core.ui.ViewModel
import javax.inject.Inject

class WorkoutViewModel @Inject constructor() :
    ViewModel<WorkoutViewModel.ViewState, WorkoutViewModel.Action>(ViewState(), update) {

    data class ViewState(
        val placeholder: Int = 0
    )

    sealed class Action {

    }
}

private val update: (WorkoutViewModel.ViewState, WorkoutViewModel.Action) -> WorkoutViewModel.ViewState =
    { state, action ->
        state
    }
