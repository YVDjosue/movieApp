package com.wanku.movieapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre_table")
data class GenreEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") val id: Int =0,

    @ColumnInfo(name="movieId")val movieId: Int,

    @ColumnInfo(name="genreId")val genreId: Int
        )