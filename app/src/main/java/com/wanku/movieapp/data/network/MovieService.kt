package com.wanku.movieapp.data.network

import com.wanku.movieapp.core.RetrofitHelper
import com.wanku.movieapp.data.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getMovies():MovieModel?{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(MovieApiClient::class.java).getAllMovies()
            response.body()
        }
    }
}