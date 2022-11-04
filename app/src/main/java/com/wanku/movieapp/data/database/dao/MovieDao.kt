package com.wanku.movieapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wanku.movieapp.data.database.entities.MovieEntity
import com.wanku.movieapp.data.model.MovieModel
import com.wanku.movieapp.data.model.ResultModel

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    suspend fun getAllMovies():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies:List<MovieEntity>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllmovies()
}