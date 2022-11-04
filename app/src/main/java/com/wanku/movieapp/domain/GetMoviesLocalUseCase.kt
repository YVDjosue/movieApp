package com.wanku.movieapp.domain

import com.wanku.movieapp.data.MovieRepository
import com.wanku.movieapp.domain.model.Movie
import javax.inject.Inject

class GetMoviesLocalUseCase @Inject constructor(
    private val movieProvider : MovieRepository
) {

    suspend operator fun invoke(): List<Movie> {
        return movieProvider.getAllFromDatabase()
    }
}