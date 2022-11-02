package com.wanku.movieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wanku.movieapp.data.model.MovieModel
import com.wanku.movieapp.data.model.MovieProvider

class MovieViewModel:ViewModel() {
    val movieModel = MutableLiveData<MovieModel?>()

    fun getMovies(){
        val currentMovies: MovieModel? = MovieProvider.movies
        movieModel.postValue(currentMovies)
    }
}