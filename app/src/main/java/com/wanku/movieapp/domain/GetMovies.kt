package com.wanku.movieapp.domain

import com.wanku.movieapp.data.MovieRepository
import com.wanku.movieapp.data.model.MovieModel

class GetMovies {
    private val repository = MovieRepository()

    suspend operator fun invoke():MovieModel?=repository.getAllMovies()
}