package com.nada.gitlearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn:Button=findViewById(R.id.btn)
        val ed_msg:EditText=findViewById(R.id.ed_msg)
        btn.setOnClickListener {
            if (ed_msg.text.toString().isEmpty())return@setOnClickListener
            //Snackbar.make(it,"hello ${ed_msg.text.toString()}",Snackbar.LENGTH_LONG).show()
            val intent = Intent(this@MainActivity,DetailsActivity::class.java)
            intent.putExtra("msg",ed_msg.text.toString())
            startActivity(intent)
        }
    }
}