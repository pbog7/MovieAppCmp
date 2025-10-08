package com.example.movielist.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.ActionState
import com.example.domain.models.Movie
import com.example.movielist.item.MovieItem
import com.example.movielist.MovieListOrientation
import com.example.movielist.item.MoviePlaceholderItem


@Composable
fun MovieList(
    state: ActionState<List<Movie>>,
    modifier: Modifier = Modifier,
    orientation: MovieListOrientation = MovieListOrientation.Vertical,
    onMovieClick: (Movie) -> Unit
) {
    val movies = state.data
    val isEmpty = movies.isNullOrEmpty() && state.isLoading
    val itemCount = if (isEmpty) 4 else movies?.size ?: 0

    val content: @Composable LazyItemScope.(Int) -> Unit = { index ->
        if (isEmpty) {
            MoviePlaceholderItem(orientation = orientation)
        } else {
            val movie = movies!![index]
            MovieItem(
                movie = movie,
                modifier = if (orientation == MovieListOrientation.Vertical) Modifier.fillMaxWidth() else Modifier,
                onClick = onMovieClick,
                orientation = orientation
            )
        }
    }

    when (orientation) {
        MovieListOrientation.Horizontal -> LazyRow(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(count = itemCount, itemContent = content)
        }

        MovieListOrientation.Vertical -> LazyColumn(
            modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(count = itemCount, itemContent = content)
        }
    }
}

