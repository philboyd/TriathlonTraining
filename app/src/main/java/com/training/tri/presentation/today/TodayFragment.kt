package com.training.tri.presentation.today

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.training.tri.R
import kotlinx.android.synthetic.main.fragment_today.*

/**
 * A simple [Fragment] subclass.
 */
class TodayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        text.setOnClickListener {
            this.findNavController().navigate(R.id.action_todayFragment_to_logWorkoutFragment)
        }
    }


}
