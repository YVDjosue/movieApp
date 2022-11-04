package com.wanku.movieapp.domain

import com.wanku.movieapp.data.MovieRepository
import com.wanku.movieapp.data.database.entities.toDatabase
import com.wanku.movieapp.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class GetMoviesUseCaseTest{

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository

    private lateinit var getMoviesUseCase: GetMoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getMoviesUseCase = GetMoviesUseCase(movieRepository)
    }

    @Test
    fun whenTheApiDoesntReturnAnythingThenGetValuesFromDatabase() = runBlocking {
        //Given
        coEvery { movieRepository.getAllMoviesFromApi() } returns emptyList()

        //When
        getMoviesUseCase()

        //Then
        coVerify(exactly = 1) { movieRepository.getAllFromDatabase() }
    }

    @Test
    fun whenTheApiReturnSomethingThenGetValuesFromApi() = runBlocking {
        //Given
        val movieList = listOf(Movie(
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
        coEvery { movieRepository.getAllMoviesFromApi() } returns movieList

        //When
        val response = getMoviesUseCase()

        //Then
        coVerify(exactly = 1) { movieRepository.clearMovies() }
        coVerify(exactly = 1) { movieRepository.insertMovies(any()) }
        coVerify(exactly = 0) { movieRepository.getAllFromDatabase() }
        assert(movieList==response)
    }
}