package com.training.tri.core.ui

import com.training.tri.core.ui.util.setSynchronous
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class ViewModelTest : DescribeSpec() {

    override fun isolationMode(): IsolationMode? = IsolationMode.InstancePerLeaf

    private val sut = SampleViewModel()

    init {
        setSynchronous()

        describe("Sample viewmodel") {
            it("has default viewstate") {
                sut.observe().first() shouldBe SampleViewModel.ViewState()
            }

            context("dispatching actions") {
                context("action with no parameters") {
                    it("updates based on dispatched action") {
                        sut.dispatch(SampleViewModel.Action.ItemClicked)
                        sut.observe().first().data shouldBe SampleViewModel.Data.STATE_TWO
                    }
                }
                context("action with parameters") {
                    it("updates based on param in action") {
                        forAll(
                            row(SampleViewModel.Data.INITIAL),
                            row(SampleViewModel.Data.STATE_TWO),
                            row(SampleViewModel.Data.STATE_THREE)
                        ) { data ->
                            sut.dispatch(SampleViewModel.Action.DataFetched(data))
                            sut.observe().first().data shouldBe data
                        }
                    }
                }
                context("simulate a onDestroy lifecycle event") {
                    it("stream doesn't emit more items") {
                        val scope = CoroutineScope(Dispatchers.Default)
                        sut.observe()
                            .drop(1)
                            .onEach { throw Exception("stream should be ended") }
                            .launchIn(scope)

                        scope.cancel()
                        sut.dispatch(SampleViewModel.Action.ItemClicked)
                    }
                }
            }
        }
    }
}

class SampleViewModel : ViewModel<SampleViewModel.ViewState, SampleViewModel.Action>(ViewState(), update) {
    data class ViewState(
        val data: Data = Data.INITIAL
    )

    sealed class Action {
        object ItemClicked : Action()
        data class DataFetched(val data: Data) : Action()
    }

    enum class Data {
        INITIAL,
        STATE_TWO,
        STATE_THREE
    }
}

val update: (SampleViewModel.ViewState, SampleViewModel.Action) -> SampleViewModel.ViewState = { state, action ->
    when (action) {
        SampleViewModel.Action.ItemClicked -> state.copy(data = SampleViewModel.Data.STATE_TWO)
        is SampleViewModel.Action.DataFetched -> state.copy(data = action.data)
    }
}
