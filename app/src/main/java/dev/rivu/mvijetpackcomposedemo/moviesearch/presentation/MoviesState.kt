package dev.rivu.mvijetpackcomposedemo.moviesearch.presentation

import dev.rivu.mvijetpackcomposedemo.base.MviState
import dev.rivu.mvijetpackcomposedemo.moviesearch.data.model.Movie
import dev.rivu.mvijetpackcomposedemo.moviesearch.data.model.MovieDetail
import dev.rivu.mvijetpackcomposedemo.utils.emptyString
import java.lang.Exception

data class MoviesState(
    val query: String = emptyString(),
    val movies: List<Movie> = listOf(),
    val error: Throwable? = null,
    val isLoading: Boolean = false,
    val detail: MovieDetail? = null
) : MviState {
    companion object {
        fun initialState(): MoviesState = MoviesState()
    }
}

fun MoviesState.isIdleState() =
    query.isBlank() && movies.isEmpty() && error == null && !isLoading && detail == null

fun MoviesState.isDetailState() =
    detail != null

fun MoviesState.resetDetailState(): MoviesState = copy(detail = null)