package com.wanku.movieapp.data.network

import com.wanku.movieapp.data.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {
    @GET("3/movie/upcoming?page=1&api_key=edc6c1d057539da6e734d0c42a53b2f7")
    suspend fun getAllMovies():Response<MovieModel>
}