package com.wanku.movieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wanku.movieapp.domain.GetMoviesLocalUseCase
import com.wanku.movieapp.domain.GetMoviesUseCase
import com.wanku.movieapp.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMoviesUseCase : GetMoviesUseCase,
    private val getMoviesLocalUseCase : GetMoviesLocalUseCase
):ViewModel() {
    val movieModel = MutableLiveData<List<Movie>>()

    //var getMoviesUseCase = GetMoviesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getMoviesUseCase()
            movieModel.postValue(result)
        }
    }

    fun getMovies(){
        viewModelScope.launch {
            val currentMovies = getMoviesLocalUseCase()
            movieModel.postValue(currentMovies)
        }
    }


}