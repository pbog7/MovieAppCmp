package com.example.movielist.item

import coil3.compose.AsyncImage
import com.example.domain.models.Movie
import androidx.compose.runtime.Composable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.movielist.MovieListOrientation

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    onClick: (Movie) -> Unit,
    orientation: MovieListOrientation
) {
    val posterWidth: Dp
    val posterHeight: Dp
    val spacing: Dp
    when (orientation) {
        MovieListOrientation.Horizontal -> {
            posterHeight = HorizontalMovieItemSizes.PosterHeight.dp
            posterWidth = HorizontalMovieItemSizes.PosterWidth.dp
            spacing = HorizontalMovieItemSizes.Spacing.dp
        }

        MovieListOrientation.Vertical -> {
            posterHeight = VerticalMovieItemSizes.PosterHeight.dp
            posterWidth = VerticalMovieItemSizes.PosterWidth.dp
            spacing = VerticalMovieItemSizes.Spacing.dp
        }
    }

    Column(
        modifier = modifier
            .width(posterWidth)
            .clickable { onClick(movie) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = movie.thumbnail,
            contentDescription = movie.title,
            modifier = Modifier
                .height(posterHeight)
                .fillMaxWidth()
        )
        Spacer(Modifier.height(spacing))
        Text(
            text = movie.title,
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )
    }
}
