package com.wanku.movieapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.wanku.movieapp.domain.GetMoviesLocalUseCase
import com.wanku.movieapp.domain.GetMoviesUseCase
import com.wanku.movieapp.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

@ExperimentalCoroutinesApi
internal class MovieViewModelTest{
    @RelaxedMockK
    private lateinit var getMoviesUseCase : GetMoviesUseCase

    @RelaxedMockK
    private lateinit var getMoviesLocalUseCase : GetMoviesLocalUseCase

    private lateinit var movieViewModel: MovieViewModel


    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        movieViewModel = MovieViewModel(getMoviesUseCase,getMoviesLocalUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun whenViewModelIsCreatedAtTheFirstTimeGetAllMovies() = runTest{
        //Given
        val movieList = listOf(
                Movie(
                1,
                true,
                "/y5Z0WesTjvn59jP6yo459eUsbli.jpg",
                "en",
                "El conjuro",
                "La historia de Anabel y los Warren",
                7842.699,
                "/b6IRp6Pl2Fsq37r9jFhGoLtaqHm.jpg",
                "2022-10-06",
                "El conjuro",
                false,
                7.4,
                123),
            Movie(2,
                true,
                "/y5Z0WesTjvn59jP6yo459eUsbli.jpg",
                "es",
                "Interestelar",
                "Pelicula de ciencia ficción galardonada por su fidelidad a la ciencia",
                53624.699,
                "/b6IRp6Pl2Fsq37r9jFhGoLtaqHm.jpg",
                "2020-11-12",
                "Interestelar",
                false,
                9.2,
                252)
        )
        coEvery { getMoviesUseCase() } returns movieList

        //When
        movieViewModel.onCreate()

        //Then
        //assert(movieViewModel.movieModel,movieList)
        assert(movieViewModel.movieModel.value==movieList)

    }
}