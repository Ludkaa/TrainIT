package com.example.trainit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_actual_weather).setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_SecondFragment)
        }
        view.findViewById<Button>(R.id.button_new_activity).setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_MapsFragment)
        }
    }
}