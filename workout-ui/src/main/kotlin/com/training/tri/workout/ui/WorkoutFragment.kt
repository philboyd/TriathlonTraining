package com.training.tri.workout.ui

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class WorkoutFragment :  Fragment(R.layout.fragment_workout) {

    @Inject
    lateinit var viewModel: WorkoutViewModel

    override fun onResume() {
        super.onResume()

        viewModel.observe()
            .onEach { Log.i("TAG", it.toString()) }
            .launchIn(lifecycle.coroutineScope)
    }
}