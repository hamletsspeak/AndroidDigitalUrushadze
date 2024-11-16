package com.example.myapplication2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class item_product : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name_product = findViewById<TextView>(R.id.name_product)
        val price_product = findViewById<TextView>(R.id.price_product)
        val look_product = findViewById<TextView>(R.id.look_product)



        name_product.text = intent.getStringExtra("item_title")
        price_product.text = intent.getStringExtra("item_text")
        look_product.text = intent.getStringExtra("item_price")
    }
}