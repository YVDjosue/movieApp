package com.wanku.movieapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wanku.movieapp.domain.model.Movie

@Entity(tableName = "movie_table")
data class MovieEntity (

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "adult")
    val adult: Boolean,

    @ColumnInfo(name = "backdropPath")
    val backdropPath: String,

    @ColumnInfo(name = "originalLanguage")
    val originalLanguage: String,

    @ColumnInfo(name = "originalTitle")
    val originalTitle: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @ColumnInfo(name = "posterPath")
    val posterPath: String,

    @ColumnInfo(name = "releaseDate")
    val releaseDate: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "video")
    val video: Boolean,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Double,

    @ColumnInfo(name = "voteCount")
    val voteCount: Int
        )

fun Movie.toDatabase() = MovieEntity(
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
    voteCount=voteCount)