package com.example.androidfundamentalskit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AnimalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)

        val animals = listOf(
            Animal("Барсик", "Кот", 3, R.mipmap.ic_launcher),
            Animal("Шарик", "Собака", 5, R.mipmap.ic_launcher),
            Animal("Симба", "Лев", 2, R.mipmap.ic_launcher),
            Animal("Кеша", "Попугай", 1, R.mipmap.ic_launcher),
            Animal("Барсик", "Кот", 3, R.mipmap.ic_launcher),
            Animal("Шарик", "Собака", 5, R.mipmap.ic_launcher),
            Animal("Симба", "Лев", 2, R.mipmap.ic_launcher),
            Animal("Кеша", "Попугай", 1, R.mipmap.ic_launcher),
            Animal("Барсик", "Кот", 3, R.mipmap.ic_launcher),
            Animal("Шарик", "Собака", 5, R.mipmap.ic_launcher),
            Animal("Симба", "Лев", 2, R.mipmap.ic_launcher),
            Animal("Кеша", "Попугай", 1, R.mipmap.ic_launcher),
            Animal("Барсик", "Кот", 3, R.mipmap.ic_launcher),
            Animal("Шарик", "Собака", 5, R.mipmap.ic_launcher),
            Animal("Симба", "Лев", 2, R.mipmap.ic_launcher),
            Animal("Кеша", "Попугай", 1, R.mipmap.ic_launcher)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.animalRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = AnimalAdapter(animals)
    }
}