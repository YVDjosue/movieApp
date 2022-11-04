package com.wanku.movieapp.data

import com.wanku.movieapp.data.database.dao.MovieDao
import com.wanku.movieapp.data.database.entities.MovieEntity
import com.wanku.movieapp.data.model.ResultModel
import com.wanku.movieapp.data.network.MovieService
import com.wanku.movieapp.domain.model.Movie
import com.wanku.movieapp.domain.model.toDomain
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api : MovieService,
    private val movieDao : MovieDao
) {
    suspend fun getAllMoviesFromApi():List<Movie>{
        val response: List<ResultModel> = api.getMovies()
        return response.map { it.toDomain()}
    }

    suspend fun getAllFromDatabase():List<Movie>{
        val response: List<MovieEntity> = movieDao.getAllMovies()
        return response.map { it.toDomain() }
    }

    suspend fun insertMovies(movies:List<MovieEntity>){
        movieDao.insertAll(movies)
    }

    suspend fun clearMovies(){
        movieDao.deleteAllmovies()
    }
}