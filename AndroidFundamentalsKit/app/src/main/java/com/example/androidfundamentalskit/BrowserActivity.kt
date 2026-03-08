package com.example.androidfundamentalskit

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class BrowserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        val etUrl = findViewById<EditText>(R.id.etUrl)
        val btnGo = findViewById<Button>(R.id.btnGo)
        val webView = findViewById<WebView>(R.id.webView)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = WebViewClient()

        btnGo.setOnClickListener {
            var url = etUrl.text.toString()

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://$url"
            }

            webView.loadUrl(url)
        }
    }
}