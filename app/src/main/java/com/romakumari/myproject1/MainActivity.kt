package com.romakumari.myproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var etName : EditText? = null
    var etcollege : EditText? = null
    var etphoneNumber  : EditText? = null
    var btnvalidate : Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etcollege= findViewById(R.id.etCollege)
        etphoneNumber=findViewById(R.id.etNumber)
        btnvalidate=findViewById(R.id.btnvalidate)

        btnvalidate?.setOnClickListener {
            if (etName?.text.isNullOrEmpty()){
                etName?.error="enter your name"
            }
            else if (etcollege?.text.isNullOrEmpty()){
                etcollege?.error=" enter your college name"
            }
            else if (etphoneNumber?.text.isNullOrEmpty()){
                etphoneNumber?.error="enter your phone"
            }
            else  {
                Toast.makeText(this, " validate is sucessfull" , Toast.LENGTH_LONG).show()
            var intent= Intent(this ,CheckboxRadioActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


    }




}