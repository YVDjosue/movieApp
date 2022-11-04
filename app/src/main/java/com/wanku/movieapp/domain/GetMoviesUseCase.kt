package com.wanku.movieapp.domain

import com.wanku.movieapp.data.MovieRepository
import com.wanku.movieapp.data.database.entities.toDatabase
import com.wanku.movieapp.domain.model.Movie
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
){

    suspend operator fun invoke() : List<Movie>{
        val movies = repository.getAllMoviesFromApi()

        return if(movies.isNotEmpty()){
            repository.clearMovies()
            repository.insertMovies(movies.map { it.toDatabase() })
            movies
        }
        else{
            repository.getAllFromDatabase()
        }
    }
}