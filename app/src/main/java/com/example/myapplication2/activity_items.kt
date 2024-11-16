package com.example.myapplication2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class activity_items : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            val itemslist: RecyclerView = findViewById(R.id.itemslist)
            val items = arrayListOf<Item>()
            items.add(Item(1,"Pen","Ручка шариковая","Для бумаги","Полезная",150))
            items.add(Item(2,"Pencile","Карандаш чёрный","Для бумаги","Полезный",100))
            items.add(Item(3,"Paper","Бумага А4","Для записей","Важная вещь",75))
            items.add(Item(4,"Steel","Точилка для карандаша","Точит карандаш","Чтобы карандаш был острый",200))
            items.add(Item(5,"Marker","Маркер для доски","Пишет на спец. доске","Чёрный",120))


            itemslist.layoutManager=LinearLayoutManager(this)
            itemslist.adapter=ItemsAdapter(items,this)
    }
    }
