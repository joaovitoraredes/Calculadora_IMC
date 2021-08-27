package com.jv_aredess.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("lifecicle","CREATE - estou criando a tela")
    }

    override fun onStart(){
        super.onStart()
        Log.w("lifecicle","entrei no START - deixei a tela visível para você")
    }

    override fun onResume(){
        super.onResume()
        Log.w("lifecicle","entrei no Resume - agora você pode interagir com a tela")
    }

    override fun onPause(){
        super.onPause()
        Log.w("lifecicle","PAUSE - a tela perdeu o foco, você não pode mais interagir")
    }

    override fun onStop(){
        super.onStop()
        Log.w("lifecicle","STOP - a tela não está mais visível mas ainda existe")
    }

    override fun onRestart(){
        super.onRestart()
        Log.w("lifecicle","\nRESTART - a tela está retomando o foco")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.w("lifecicle","\nDESTROY - oh não! a tela foi destruída")
    }
}