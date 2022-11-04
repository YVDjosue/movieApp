package com.wanku.movieapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wanku.movieapp.data.database.dao.MovieDao
//import com.wanku.movieapp.data.database.entities.GenreEntity
import com.wanku.movieapp.data.database.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao() : MovieDao
}