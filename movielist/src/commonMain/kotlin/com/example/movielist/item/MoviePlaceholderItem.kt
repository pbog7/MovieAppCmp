package com.example.movielist.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core.shimmer.ShimmerBox
import com.example.movielist.MovieListOrientation

@Composable
fun MoviePlaceholderItem(
    orientation: MovieListOrientation
) {
    val posterWidth: Int
    val posterHeight: Int
    val spacing: Int

    when (orientation) {
        MovieListOrientation.Horizontal -> {
            posterHeight = HorizontalMovieItemSizes.PosterHeight
            posterWidth = HorizontalMovieItemSizes.PosterWidth
            spacing = HorizontalMovieItemSizes.Spacing
        }

        MovieListOrientation.Vertical -> {
            posterHeight = VerticalMovieItemSizes.PosterHeight
            posterWidth = VerticalMovieItemSizes.PosterWidth
            spacing = VerticalMovieItemSizes.Spacing
        }
    }

    Column(
        modifier = Modifier.width(posterWidth.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Poster placeholder
        ShimmerBox(
            width = posterWidth,
            height = posterHeight,
        )
        Spacer(Modifier.height(spacing.dp))
        // Title placeholder
        ShimmerBox(
            width = (posterWidth * 0.7f).toInt(), // simulate shorter title
            height = 16,
        )
    }
}

