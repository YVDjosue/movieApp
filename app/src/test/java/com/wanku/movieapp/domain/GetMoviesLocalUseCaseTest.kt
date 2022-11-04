package com.wanku.movieapp.domain

import com.wanku.movieapp.data.MovieRepository
import com.wanku.movieapp.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class GetMoviesLocalUseCaseTest{
    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository

    lateinit var getMoviesLocalUseCase: GetMoviesLocalUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getMoviesLocalUseCase = GetMoviesLocalUseCase(movieRepository)
    }

    @Test
    fun whenDatabaseIsEmptyThenReturnEmptyList() = runBlocking {
        //Given
        coEvery { movieRepository.getAllFromDatabase() } returns emptyList()

        //When
        val response = getMoviesLocalUseCase()

        //Then
        assert(response.isEmpty())
    }

    @Test
    fun whenDatabaseIsNotEmptyThenReturnListMovies() = runBlocking {
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
        coEvery { movieRepository.getAllFromDatabase() } returns movieList

        //When
        val response = getMoviesLocalUseCase()

        //Then
        assert(movieList==response)
    }

}