package com.example.myapplication2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter (var items:List<Item>, var context: Context):RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {
    class MyViewHolder(view:View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.item_image)
        val title = view.findViewById<TextView>(R.id.item_title)
        val description = view.findViewById<TextView>(R.id.item_description)
        val price = view.findViewById<TextView>(R.id.item_price)
        val button_item: Button = view.findViewById(R.id.button_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.description.text = items[position].description
        holder.price.text = items[position].price.toString()
        holder.button_item.setOnClickListener{
            val intent = Intent(context, item_product::class.java)
            intent.putExtra("item_title", items[position].title)
            intent.putExtra("item_text", items[position].text)
            intent.putExtra("item_price", items[position].price)
            context.startActivity(intent)
        }

    }
}