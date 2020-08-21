package com.training.tri.workout.ui

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain


class WorkoutViewModelTest : DescribeSpec() {

    override fun isolationMode(): IsolationMode? = IsolationMode.InstancePerLeaf

    private val sut = WorkoutViewModel()

    init {
        // TODO make a test util module and put this there
        Dispatchers.setMain(TestCoroutineDispatcher())

        describe("Workout ViewModel") {
            it("has default viewstate") {
                sut.observe().first() shouldBe WorkoutViewModel.ViewState()
            }
        }
    }
}
