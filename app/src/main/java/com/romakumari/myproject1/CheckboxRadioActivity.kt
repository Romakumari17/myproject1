package com.romakumari.myproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast

class CheckboxRadioActivity : AppCompatActivity() {
    var cbIagree: CheckBox?= null
    var rbfemale: RadioButton?=null
    var rbmale: RadioButton?=null
    var rbother: RadioButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_radio)
        cbIagree=findViewById(R.id.cbIagree)
        rbfemale=findViewById(R.id.rbfemale)
        rbmale=findViewById(R.id.rbmale)
        rbother=findViewById(R.id.rbother)
        cbIagree?.setOnCheckedChangeListener{_,isChecked->
            if (isChecked)
            {Toast.makeText(this,"checked",Toast.LENGTH_SHORT).show()

                }  else {
                Toast.makeText(this, "Not checked", Toast.LENGTH_SHORT).show()
            }

            }
    }
}