package com.example.newsapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()

        val url = intent.getStringExtra("url")
        webView.loadUrl(url ?: "https://newsapi.org")
    }
}
