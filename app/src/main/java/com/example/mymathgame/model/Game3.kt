package com.example.mymathgame.model

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext
import kotlin.random.Random

class Game3() {

    fun PlayGame(TextViewLevel:TextView,TextViewCoroutines:TextView,TextViewMathExample:TextView,EditTextResult:EditText
    ,ButtonRespond:Button,Complexity:String,ButtonAgain:Button,TextViewTime: TextView){

        var level = 1
        val empty = ""
        var count1 = 0
        var count2 = 0

        TextViewCoroutines.text = ""

        var job = Time(TextViewCoroutines,20,ButtonAgain,ButtonRespond)

        TextViewLevel.text = "уровень: $level"
        TextViewTime.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.Main).launch {
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

            job.start()
            TextViewTime.text = ""

        }


        count1 = getRandomInt(Complexity)
        count2 = getRandomInt(Complexity)


        TextViewMathExample.text = "$count1 + $count2 = ?"

        ButtonRespond.setOnClickListener {

            if (job.isActive){
                job.cancel()

                if (EditTextResult.text.toString().toInt() == count1 + count2){

                    level+=1
                    TextViewLevel.text = "уровень: $level"
                    EditTextResult.setText(empty)

                    count1 = getRandomInt(Complexity)
                    count2 = getRandomInt(Complexity)

                    job = Time(TextViewCoroutines,20,ButtonAgain,ButtonRespond)
                    job.start()

                    TextViewMathExample.text = "$count1 + $count2 = ?"

                }else{

                    ButtonRespond.isClickable = false
                    ButtonAgain.visibility = View.VISIBLE
                    TextViewMathExample.text = "неверно "

                }
            }
        }
    }



    fun Time(TextViewTime:TextView,Time:Int,ButtonAgain: Button,ButtonGo: Button): Job {
        var time = Time
        var job = CoroutineScope(Dispatchers.Main).launch(start = CoroutineStart.LAZY) {
            while (time>-1){
                TextViewTime.text = time.toString()
                delay(1000)
                time-=1
            }
            TextViewTime.text = "время вышло"
            ButtonGo.isClickable = false
            ButtonAgain.visibility = View.VISIBLE
        }
        return job
    }


    fun getRandomInt(Complexity:String):Int {
        var count = 0
        when(Complexity){
            "easy" -> {
                count = Random(System.currentTimeMillis()).nextInt(0,10)
            }

            "middle" -> {
                count= Random(System.currentTimeMillis()).nextInt(0,20)
            }

            "hard" -> {
                count = Random(System.currentTimeMillis()).nextInt(0,30)
            }

            else -> {
                count = Random(System.currentTimeMillis()).nextInt(0,30)
            }
        }
        return count
    }


}


