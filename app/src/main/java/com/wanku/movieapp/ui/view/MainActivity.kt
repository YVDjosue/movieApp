package com.wanku.movieapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wanku.movieapp.databinding.ActivityMainBinding
import com.wanku.movieapp.ui.view.common.ListAdapter
import com.wanku.movieapp.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private val movieViewModel: MovieViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rvMovies

        movieViewModel.movieModel.observe(this, Observer { currentMovies ->
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = ListAdapter(currentMovies)
        })

        binding.viewContainer.setOnClickListener {
            movieViewModel.onCreate()
            //movieViewModel.getMovies()
        }


    }
}