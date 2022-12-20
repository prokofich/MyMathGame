package com.example.mymathgame.model

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Game2() {

    fun PlayGame(ButtonRespond: Button, TextViewMathExample: TextView, EditTextResult: EditText, TextViewLevel: TextView,
                 TextViewRight: TextView, TextViewWrong: TextView, Complexity:String, MaxLevel:Int, ButtonAgain: Button,
                 CountNumber:Int,TextViewTime:TextView
    ){

        TextViewTime.visibility = View.VISIBLE

        var RightAnswer = 0
        var WrongAnswer= 0
        var level = 1
        val empty = ""

        CoroutineScope(Dispatchers.Main).launch{
            var time = 4
            TextViewMathExample.visibility = View.GONE
            ButtonRespond.isClickable = false
            while(time!=0){
                delay(1000)
                time-=1
                TextViewTime.text = time.toString()
            }
            TextViewTime.text = "поехали!"
            delay(1000)
            ButtonRespond.isClickable = true
            TextViewTime.visibility = View.GONE
            TextViewMathExample.visibility = View.VISIBLE

            TextViewTime.text = ""

        }


        TextViewLevel.text = "уровень: $level"
        TextViewRight.text = "правильно: $RightAnswer"
        TextViewWrong.text = "неправильно: $WrongAnswer"

        var ListCountAndSymbol = getListCountAndSymbol(Complexity)
        var Otvet = getResult(ListCountAndSymbol)

        var StrCountAndSymbol = ""
        for (i in 0..CountNumber*2-2){
            StrCountAndSymbol+=ListCountAndSymbol[i]
        }

        TextViewMathExample.text = StrCountAndSymbol

        ButtonRespond.setOnClickListener {
            if (EditTextResult.text.toString() == Otvet.toString()) {
                RightAnswer+=1
                TextViewRight.text = "правильно: ${RightAnswer}"
                EditTextResult.setText(empty)
                level+=1

                if (level!=MaxLevel+1) {
                    TextViewLevel.text = "уровень: $level"
                    ListCountAndSymbol.clear()

                    ListCountAndSymbol = getListCountAndSymbol(Complexity)
                    Otvet = getResult(ListCountAndSymbol)

                    var StrCountAndSymbol = ""
                    for (i in 0..CountNumber * 2 - 2) {
                        StrCountAndSymbol += ListCountAndSymbol[i]
                    }

                    TextViewMathExample.text = StrCountAndSymbol
                }else{
                    TextViewMathExample.text = "Вы решили все уровни"
                    ButtonRespond.isClickable = false
                    ButtonAgain.visibility = View.VISIBLE
                    level=1
                }

            }else{

                WrongAnswer+=1
                TextViewWrong.text = "неправильно: ${WrongAnswer}"
                EditTextResult.setText(empty)
                level+=1

                if (level!=MaxLevel+1) {
                    TextViewLevel.text = "уровень: $level"
                    ListCountAndSymbol.clear()

                    ListCountAndSymbol = getListCountAndSymbol(Complexity)
                    Otvet = getResult(ListCountAndSymbol)

                    var StrCountAndSymbol = ""
                    for (i in 0..CountNumber * 2 - 2) {
                        StrCountAndSymbol += ListCountAndSymbol[i]
                    }

                    TextViewMathExample.text = StrCountAndSymbol
                }else{
                    TextViewMathExample.text = "Вы решили все уровни"
                    ButtonRespond.isClickable = false
                    ButtonAgain.visibility = View.VISIBLE
                    level = 1
                }
            }
        }
    }



    fun getListCountAndSymbol(complexity: String): MutableList<String> {
        var ListCountAndSymbol = mutableListOf<String>()
        var ListSymbol = listOf("+","-")
        when(complexity){
            "easy" -> {
                for (i in 0 until 5){
                    ListCountAndSymbol.add(Random(System.currentTimeMillis()).nextInt(0,10).toString())
                    if(i!=5-1){
                        ListCountAndSymbol.add(ListSymbol[(0..1).random()])
                    }
                }
            }
            "middle" -> {
                for (i in 0 until 10){
                    ListCountAndSymbol.add(Random(System.currentTimeMillis()).nextInt(0,15).toString())
                    if(i!=10-1){
                        ListCountAndSymbol.add(ListSymbol[(0..1).random()])
                    }
                }
            }
            "hard" -> {
                for (i in 0 until 15){
                    ListCountAndSymbol.add(Random(System.currentTimeMillis()).nextInt(0,20).toString())
                    if(i!=15-1){
                        ListCountAndSymbol.add(ListSymbol[(0..1).random()])
                    }
                }
            }
        }
        return ListCountAndSymbol
    }

    fun getResult(list:MutableList<String>): Int {
        var Otvet = list[0].toInt()
        for (i in 1 until list.size - 1) {
            when (list[i]) {
                "+" -> {
                    Otvet += list[i + 1].toInt()
                }
                "-" -> {
                    Otvet -= list[i + 1].toInt()
                }
            }
        }
        return Otvet
    }

}