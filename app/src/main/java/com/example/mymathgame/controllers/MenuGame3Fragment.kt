package com.example.mymathgame.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymathgame.MAIN
import com.example.mymathgame.R
import kotlinx.android.synthetic.main.fragment_menu_game3.*

class MenuGame3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_game3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id_menugame3_nextgame3_eazy.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("complexity","easy")
            MAIN.navController.navigate(R.id.action_menuGame3Fragment_to_game3Fragment,bundle)
        }

        id_menugame3_nextgame3_middle.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("complexity","middle")
            MAIN.navController.navigate(R.id.action_menuGame3Fragment_to_game3Fragment,bundle)
        }

        id_menugame3_nextgame3_hard.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("complexity","hard")
            MAIN.navController.navigate(R.id.action_menuGame3Fragment_to_game3Fragment,bundle)
        }


        id_menugame3_back.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuGame3Fragment_to_menuFragment)
        }

    }

}