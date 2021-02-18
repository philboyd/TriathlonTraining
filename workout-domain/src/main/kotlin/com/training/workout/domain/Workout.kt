package com.training.workout.domain

sealed class Workout {

    data class Cardio(
        val discipline: Sport,
        val durationInMinutes: Int,
        val effort: Effort?,
        val distance: Double?
    )
}
