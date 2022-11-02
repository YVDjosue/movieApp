package com.wanku.movieapp.data

import com.wanku.movieapp.data.model.MovieModel
import com.wanku.movieapp.data.model.MovieProvider
import com.wanku.movieapp.data.network.MovieService

class MovieRepository {

    private val api = MovieService()

    suspend fun getAllMovies():MovieModel?{
        val response = api.getMovies()
        MovieProvider.movies=response
        return response
    }
}