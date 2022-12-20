package com.example.mymathgame.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymathgame.MAIN
import com.example.mymathgame.R
import kotlinx.android.synthetic.main.fragment_menu_game1.*
import kotlinx.android.synthetic.main.fragment_menu_game2.*

class MenuGame2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_game2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id_menugame2_nextgame2_eazy.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("complexity","easy")
            bundle.putInt("MaxLevel",10)
            MAIN.navController.navigate(R.id.action_menuGame2Fragment_to_game2Fragment,bundle)
        }
        id_menugame2_nextgame2_middle.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("complexity","middle")
            bundle.putInt("MaxLevel",15)
            MAIN.navController.navigate(R.id.action_menuGame2Fragment_to_game2Fragment,bundle)
        }
        id_menugame2_nextgame2_hard.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("complexity","hard")
            bundle.putInt("MaxLevel",20)
            MAIN.navController.navigate(R.id.action_menuGame2Fragment_to_game2Fragment,bundle)
        }

        id_menugame2_back.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuGame2Fragment_to_menuFragment)
        }

    }

}