package com.example.mymathgame.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymathgame.MAIN
import com.example.mymathgame.R
import kotlinx.android.synthetic.main.fragment_menu.*

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


        id_menu_next1.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuFragment_to_menuGame1Fragment)
        }

        id_menu_next2.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuFragment_to_menuGame2Fragment)
        }

        id_menu_next3.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuFragment_to_menuGame3Fragment)
        }

        id_menu_exit.setOnClickListener {
            MAIN.finish()
        }


    }

}