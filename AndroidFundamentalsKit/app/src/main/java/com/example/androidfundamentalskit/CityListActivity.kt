package com.example.androidfundamentalskit

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CityListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_list);

        val cities = arrayListOf<String>("Moscow", "Dolgoprudniy", "New York", "Anapa", "Piter");

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);// android.R.layut.simple_list_item_1 это уже google сам сделал настройки

        val cityListView = findViewById<ListView>(R.id.citiesListView);

        cityListView.adapter = adapter;

        cityListView.setOnItemClickListener { parent, view, position, id ->

            val selectedCity = cities[position]

            Toast.makeText(this, "Your choice: $selectedCity", Toast.LENGTH_SHORT).show()
        }

    }
}