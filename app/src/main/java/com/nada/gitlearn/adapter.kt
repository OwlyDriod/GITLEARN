package com.nada.gitlearn

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data=ArrayList<String>()
    private var headerText:String? = null

    override fun getItemViewType(position: Int): Int {
        return when (position){
            0 -> R.layout.view_header
            data.size +1 -> R.layout.view_footer
            else ->R.layout.item_exemple
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            R.layout.view_header ->simplyHeaderholder(parent)
            R.layout.view_footer -> simplyFooter(parent)
            else -> simpleViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is simpleViewHolder -> holder.onBind(data[position-1],position)
            is simplyHeaderholder -> holder.onBind(headerText)
            is simplyFooter -> holder.onBind()
        }
    }

    override fun getItemCount(): Int {
        return data.size + 2 // the 2 for the header and the footer
    }

    fun setData(data:List<String>,headerText:String?){
        this.data.clear()
        this.data.addAll(data)
        this.headerText=headerText
    }

    inner class simpleViewHolder(parent: ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_exemple,parent,false)
    ){

        private val textView:TextView= itemView.findViewById(R.id.textView)
        fun onBind(text:String,position: Int){
            textView.text=text
            if(position % 2 == 0 )textView.setBackgroundColor(itemView.context.resources.getColor(R.color.purple_200))
            else textView.setBackgroundColor(itemView.context.resources.getColor(R.color.purple_500))
        }
    }

    //adding header and footer for our list

    inner class simplyHeaderholder(parent: ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_header,parent,false)
    ){
        private val tv_header :TextView=itemView.findViewById(R.id.tv_header)

        fun onBind(text: String?){
            tv_header.text=text ?: "no header for you "
        }

    }


    inner class simplyFooter(parent: ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_footer,parent,false)
    ){
        private val Btn_left:Button=itemView.findViewById(R.id.btn_lft)
        private val btn_right:Button=itemView.findViewById(R.id.btn_right)

        fun onBind(){

            btn_right.setOnClickListener { Log.d("TAG","clicked right ") }
            Btn_left.setOnClickListener { Log.d("TAG","clicked left ") }
        }
    }
}