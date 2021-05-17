package com.example.trainit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * Menu fragment
 *
 * @constructor Create empty Menu fragment
 */
class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //pri stlaceni buttonu actual weather
        view.findViewById<Button>(R.id.button_actual_weather).setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_WeatherFragment)
        }

        //pri stlaceni buttonu new activity
        view.findViewById<Button>(R.id.button_new_activity).setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_MapsFragment)
        }
    }
}