package com.wanku.movieapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.wanku.movieapp.databinding.ActivityMainBinding
import com.wanku.movieapp.ui.viewmodel.MovieViewModel
import com.wanku.movieapp.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieViewModel.movieModel.observe(this, Observer { currentMovie ->
            binding.tvQuote.text = currentMovie.
        })
        /*
        quoteViewModel.quoteModel.observe(this, Observer {currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })
        */
         */

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}