package com.example.androidfundamentalskit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        findViewById<Button>(R.id.btnTaskCities).setOnClickListener {
            val intent = Intent(this, CityListActivity::class.java)
            startActivity(intent);
        }
        findViewById<Button>(R.id.btnTaskAnimals).setOnClickListener {
            var intent = Intent(this, AnimalActivity::class.java)
            startActivity(intent);
        }
        findViewById<Button>(R.id.btnTaskBrowser).setOnClickListener {
            var intent = Intent(this, BrowserActivity::class.java)
            startActivity(intent)

        }
        findViewById<Button>(R.id.btnTaskMusic).setOnClickListener {
            val intent = Intent(this, MusicActivity::class.java)
            startActivity(intent)
        }
    }
}