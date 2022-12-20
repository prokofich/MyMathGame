package com.example.mymathgame.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymathgame.MAIN
import com.example.mymathgame.R
import com.example.mymathgame.model.Game3
import kotlinx.android.synthetic.main.fragment_game2.*
import kotlinx.android.synthetic.main.fragment_game3.*

class Game3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id_game3_back.setOnClickListener {
            MAIN.navController.navigate(R.id.action_game3Fragment_to_menuGame3Fragment)
        }

        var game = Game3()
        val complexity = arguments?.getString("complexity")

        when(complexity){

            "easy" -> {
                game.PlayGame(id_game3_tv_level,id_game3_tv_timer,id_game3_tv_primer,id_game3_et_result,id_game3_button_go,complexity!!,
                    id_game3_again,id_start_timer3)
            }

            "middle" -> {
                game.PlayGame(id_game3_tv_level,id_game3_tv_timer,id_game3_tv_primer,id_game3_et_result,id_game3_button_go,complexity!!,
                    id_game3_again,id_start_timer3)
            }

            "hard" -> {
                game.PlayGame(id_game3_tv_level,id_game3_tv_timer,id_game3_tv_primer,id_game3_et_result,id_game3_button_go,complexity!!,
                    id_game3_again,id_start_timer3)
            }

        }

        id_game3_again.setOnClickListener {
            id_game3_again.visibility = View.GONE
            game.PlayGame(id_game3_tv_level,id_game3_tv_timer,id_game3_tv_primer,id_game3_et_result,id_game3_button_go,complexity!!,
                id_game3_again,id_start_timer3)
        }

    }

}