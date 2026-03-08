package com.example.androidfundamentalskit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnStop = findViewById<Button>(R.id.btnStop)

        btnPlay.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            startService(intent) // ВАЖНО: тут startService!
        }

        btnStop.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            stopService(intent) // Уничтожаем сервис
        }
    }
}