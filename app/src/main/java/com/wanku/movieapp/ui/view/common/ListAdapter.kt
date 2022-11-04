package com.wanku.movieapp.ui.view.common

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wanku.movieapp.R
import com.wanku.movieapp.domain.model.Movie

class ListAdapter(private val movies: List<Movie>):RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    lateinit var urlImage: String
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.movie_element,viewGroup,false)
        return ViewHolder(v)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage:ImageView
        var itemTitle:TextView
        var itemDesc:TextView

        init {
            itemImage=itemView.findViewById(R.id.ivicon)
            itemTitle=itemView.findViewById(R.id.tvTitle)
            itemDesc=itemView.findViewById(R.id.tvDesc)
        }
    }

    override fun getItemCount(): Int {
        return  movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        val context = holder.itemView.context

        urlImage = "https://image.tmdb.org/t/p/w500/"+movie.posterPath

        Glide
            .with(context)
            .load(urlImage)
            .fitCenter()
            .into(holder.itemImage)
        //Glide.with(context).load("https://image.tmdb.org/t/p/w500/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg").into(holder.itemImage)

        holder.itemTitle.text = movie.originalTitle
        holder.itemDesc.text = movie.overview
        holder.itemImage.setOnClickListener(){

        }
    }


}