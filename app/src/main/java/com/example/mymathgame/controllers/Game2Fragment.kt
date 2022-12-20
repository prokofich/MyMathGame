package com.example.mymathgame.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymathgame.MAIN
import com.example.mymathgame.R
import com.example.mymathgame.model.Game1
import com.example.mymathgame.model.Game2
import kotlinx.android.synthetic.main.fragment_game1.*
import kotlinx.android.synthetic.main.fragment_game2.*
import kotlinx.android.synthetic.main.fragment_game3.*

class Game2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //ОБРАБОТКА ПЕРЕХОДА///////////////////////////////////////////////////////////
        id_game2_back.setOnClickListener {
            MAIN.navController.navigate(R.id.action_game2Fragment_to_menuGame2Fragment)
        }
        ///////////////////////////////////////////////////////////////////////////////


        val complexity = arguments?.getString("complexity")
        val MaxLevel = arguments?.getInt("MaxLevel")
        val CountNumber = arguments?.getInt("CountNumber")
        var game = Game2()

        when(complexity){
            "easy" -> {
                game.PlayGame(id_game2_button_go,id_game2_tv_primer,id_game2_et_result,id_game2_tv_level,
                id_game2_tv_true,id_game2_tv_false,complexity,MaxLevel!!,id_game2_again,5,id_start_timer2)
            }
            "middle" -> {
                game.PlayGame(id_game2_button_go,id_game2_tv_primer,id_game2_et_result,id_game2_tv_level,
                    id_game2_tv_true,id_game2_tv_false,complexity,MaxLevel!!,id_game2_again,10,id_start_timer2)
            }
            "hard" -> {
                game.PlayGame(id_game2_button_go,id_game2_tv_primer,id_game2_et_result,id_game2_tv_level,
                    id_game2_tv_true,id_game2_tv_false,complexity,MaxLevel!!,id_game2_again,15,id_start_timer2)
            }
        }

        id_game2_again.setOnClickListener {
            id_game2_again.visibility = View.GONE
            game.PlayGame(id_game2_button_go,id_game2_tv_primer,id_game2_et_result,id_game2_tv_level,id_game2_tv_true
                ,id_game2_tv_false,complexity!!,MaxLevel!!,id_game2_again,CountNumber!!,id_start_timer2)
        }



    }

}