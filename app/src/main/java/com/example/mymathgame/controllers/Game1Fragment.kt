package com.example.mymathgame.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymathgame.MAIN
import com.example.mymathgame.R
import com.example.mymathgame.model.Game1
import kotlinx.android.synthetic.main.fragment_game1.*

class Game1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ОБРАБОТКА ПЕРЕХОДА///////////////////////////////////////////////////////////
        id_game1_back.setOnClickListener {
            MAIN.navController.navigate(R.id.action_game1Fragment_to_menuGame1Fragment)
        }
        //////////////////////////////////////////////////////////////////////////////


        val complexity = arguments?.getString("complexity")
        val MaxLevel = arguments?.getInt("MaxLevel")
        var game = Game1()

        when(complexity){

            "easy" -> {
                game.PlayGame(id_game1_button_go,id_game1_tv_primer,id_game1_et_result,id_game1_tv_level,id_game1_tv_true
                ,id_game1_tv_false,"easy",MaxLevel!!,id_game1_again,id_start_timer1)
            }

            "middle" -> {
                game.PlayGame(id_game1_button_go,id_game1_tv_primer,id_game1_et_result,id_game1_tv_level,id_game1_tv_true
                    ,id_game1_tv_false,"middle",MaxLevel!!,id_game1_again,id_start_timer1)
            }

            "hard" -> {
                game.PlayGame(id_game1_button_go,id_game1_tv_primer,id_game1_et_result,id_game1_tv_level,id_game1_tv_true
                    ,id_game1_tv_false,"hard",MaxLevel!!,id_game1_again,id_start_timer1)
            }

        }

        id_game1_again.setOnClickListener {
            id_game1_again.visibility = View.GONE
            game.PlayGame(id_game1_button_go,id_game1_tv_primer,id_game1_et_result,id_game1_tv_level,id_game1_tv_true
                ,id_game1_tv_false,complexity!!,MaxLevel!!,id_game1_again,id_start_timer1)
        }

    }

}