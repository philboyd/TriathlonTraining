package com.training.tri.workout.ui

import com.training.tri.core.ui.ViewModel
import com.training.workout.domain.Sport
import com.training.workout.domain.Effort
import javax.inject.Inject

class WorkoutViewModel @Inject constructor() :
    ViewModel<WorkoutViewModel.ViewState, WorkoutViewModel.Action>(ViewState(), update) {

    data class ViewState(
        val discipline: Sport? = null,
        val durationInMinutes: Int? = null,
        val effort: Effort? = null,
        val distance: Double? = null
        // Add remote data for save status
    )

    sealed class Action {
        data class EnteredDiscipline(val discipline: Sport) : Action()
        data class EnteredDuration(val timeInMinutes: Int) : Action()
        data class EnteredEffort(val effort: Effort) : Action()
        data class EnteredDistance(val distance: Double?) : Action()
    }
}

private val update: (WorkoutViewModel.ViewState, WorkoutViewModel.Action) -> WorkoutViewModel.ViewState =
    { state, action ->
        when (action) {
            is WorkoutViewModel.Action.EnteredDiscipline -> state.copy(discipline = action.discipline)
            is WorkoutViewModel.Action.EnteredDuration -> state.copy(durationInMinutes = action.timeInMinutes)
            is WorkoutViewModel.Action.EnteredEffort -> state.copy(effort = action.effort)
            is WorkoutViewModel.Action.EnteredDistance -> state.copy(distance = action.distance)
        }
    }
