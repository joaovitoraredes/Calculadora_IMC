package com.jv_aredess.calculadoraimc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        alturaEDT?.doAfterTextChanged { text ->
        //    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        pesoEDT?.doOnTextChanged { text, _, _ ,_ ->
        //   titleTXT?.text = text
        }
        calcularBTN?.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calcularIMC(peso: String, altura:String){
        val dec = DecimalFormat("#,###.00") //2 casas decimais no final separado milhar "." e decimais ","
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if(peso != null && altura != null) {
            val imc = peso / (altura * altura)

            if (imc<17){
                titleTXT.text = "${dec.format(imc)} \nmuito abaixo do peso"
            }
            else if (imc>=17 && imc<18.49){
                titleTXT.text = "${dec.format(imc)} \nabaixo do peso"
            }
            else if (imc>=18.5 && imc<24.99){
                titleTXT.text = "${dec.format(imc)} \npeso normal"
            }
            else if (imc>=25 && imc<29.99){
                titleTXT.text = "${dec.format(imc)} \nacima do peso"
            }
            else if (imc>=30 && imc<34.99){
                titleTXT.text = "${dec.format(imc)} \nobesidade I"
            }
            else if (imc>=35 && imc<39.99){
                titleTXT.text = "${dec.format(imc)} \nobesidade II"
            }
            else{
                titleTXT.text = "${dec.format(imc)} \nobesidade III"
            }
        }
    }
}

































    /*
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
*/