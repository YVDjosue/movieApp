package com.wanku.movieapp.domain.model

import com.google.gson.annotations.SerializedName
import com.wanku.movieapp.data.database.entities.MovieEntity
import com.wanku.movieapp.data.model.MovieModel
import com.wanku.movieapp.data.model.ResultModel

data class Movie(
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

fun ResultModel.toDomain() = Movie(
    id=id,
    adult=adult,
    backdropPath=backdropPath,
    originalLanguage=originalLanguage,
    originalTitle=originalTitle,
    overview=overview,
    popularity=popularity,
    posterPath=posterPath,
    releaseDate=releaseDate,
    title=title,
    video=video,
    voteAverage=voteAverage,
    voteCount=voteCount
)
fun MovieEntity.toDomain() = Movie(
    id=id,
    adult=adult,
    backdropPath=backdropPath,
    originalLanguage=originalLanguage,
    originalTitle=originalTitle,
    overview=overview,
    popularity=popularity,
    posterPath=posterPath,
    releaseDate=releaseDate,
    title=title,
    video=video,
    voteAverage=voteAverage,
    voteCount=voteCount
)