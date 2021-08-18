package com.nada.gitlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val msg = intent.getStringExtra("msg") ?: "noMsg"
        val tv_detail :TextView=findViewById(R.id.tv_detail)
        tv_detail.text=msg

        val listdat = ArrayList<String>()
        repeat(150){index ->
            listdat.add("element $index")
        }

        val rv:RecyclerView=findViewById(R.id.rv)
        val adapter = adapter()
        adapter.setData(listdat,"list header ")

        rv.adapter=adapter
        adapter.notifyDataSetChanged()

    }
}