package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newsViewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.newsRecyclerView)
        newsAdapter = NewsAdapter { article ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("url", article.url)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = newsAdapter

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        newsViewModel.newsLiveData.observe(this) { articles ->
            newsAdapter.submitList(articles)
        }

        newsViewModel.fetchNews()
    }
}
