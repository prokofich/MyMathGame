package com.example.mymathgame.model

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.fragment_game1.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Game1() {

    fun PlayGame(ButtonRespond:Button,TextViewMathExample:TextView,EditTextResult:EditText,TextViewLevel:TextView,
                     TextViewRight:TextView,TextViewWrong:TextView,Complexity:String,MaxLevel:Int,ButtonAgain:Button,
    TextViewTime:TextView){

        var level = 1
        var RightAnswer = 0
        var WrongAnswer= 0
        val empty = ""

        TextViewTime.visibility = View.VISIBLE

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

        var count1 = getRandomInt(Complexity)
        var count2 = getRandomInt(Complexity)

        TextViewMathExample.text = "$count1 + $count2 = ?"

        ButtonRespond.setOnClickListener {

            if(EditTextResult.text.toString() == (count1+count2).toString()){
                RightAnswer+=1
                TextViewRight.text = "правильно: $RightAnswer"
                EditTextResult.setText(empty)
                if (level<MaxLevel){
                    level+=1
                    TextViewLevel.text = "уровень: $level"
                    count1 = getRandomInt(Complexity)
                    count2 = getRandomInt(Complexity)
                    TextViewMathExample.text = "$count1 + $count2 = ?"
                }else{
                    TextViewMathExample.text = "все уровни пройдены!"
                    ButtonRespond.isClickable = false
                    ButtonAgain.visibility = View.VISIBLE
                    level = 1
                }
            }else{
                WrongAnswer+=1
                TextViewWrong.text = "неправильно: $WrongAnswer"
                EditTextResult.setText(empty)
                if (level<MaxLevel){
                    level+=1
                    TextViewLevel.text = "уровень: $level"
                    count1 = getRandomInt(Complexity)
                    count2 = getRandomInt(Complexity)
                    TextViewMathExample.text = "$count1 + $count2 = ?"
                }else{
                    TextViewMathExample.text = "все уровни пройдены"
                    ButtonRespond.isClickable = false
                    ButtonAgain.visibility = View.VISIBLE
                    level = 1
                }
            }

        }
    }

    fun getRandomInt(Complexity:String):Int {
        var count = 0
        when(Complexity){
            "easy" -> {
                count = Random(System.currentTimeMillis()).nextInt(0,5)
            }

            "middle" -> {
                count= Random(System.currentTimeMillis()).nextInt(0,7)
            }

            "hard" -> {
                count = Random(System.currentTimeMillis()).nextInt(0,10)
            }

            else -> {
                count = Random(System.currentTimeMillis()).nextInt(0,10)
            }
        }
        return count
    }

}


