package com.example.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val onItemClick: (Article) -> Unit) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val articles = mutableListOf<Article>()

    fun submitList(newArticles: List<Article>) {
        articles.clear()
        articles.addAll(newArticles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
        holder.itemView.setOnClickListener { onItemClick(article) }
    }

    override fun getItemCount() = articles.size

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.newsTitle)
        private val description: TextView = itemView.findViewById(R.id.newsDescription)

        fun bind(article: Article) {
            title.text = article.title
            description.text = article.description ?: "No description available"
        }
    }
}
