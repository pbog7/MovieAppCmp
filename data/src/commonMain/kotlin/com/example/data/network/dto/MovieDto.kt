package com.example.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    @SerialName("adult") val adult: Boolean,
    @SerialName("backdrop_path") val backdropPath: String,
    @SerialName("genre_ids") val genreIds: Array<Int>,
    @SerialName("id") val id: Int,
    @SerialName("original_language") val originalLanguage: String,
    @SerialName("original_title") val originalTitle: String,
    @SerialName("overview") val overview: String,
    @SerialName("popularity") val popularity: Double,
    @SerialName("poster_path") val posterPath: String,
    @SerialName("release_date") val releaseDate: String,
    @SerialName("title") val title: String,
    @SerialName("video") val video: Boolean,
    @SerialName("vote_average") val voteAverage: Double,
    @SerialName("vote_count") val voteCount: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as MovieDto

        if (adult != other.adult) return false
        if (id != other.id) return false
        if (popularity != other.popularity) return false
        if (video != other.video) return false
        if (voteAverage != other.voteAverage) return false
        if (voteCount != other.voteCount) return false
        if (backdropPath != other.backdropPath) return false
        if (!genreIds.contentEquals(other.genreIds)) return false
        if (originalLanguage != other.originalLanguage) return false
        if (originalTitle != other.originalTitle) return false
        if (overview != other.overview) return false
        if (posterPath != other.posterPath) return false
        if (releaseDate != other.releaseDate) return false
        if (title != other.title) return false

        return true
    }

    override fun hashCode(): Int {
        var result = adult.hashCode()
        result = 31 * result + id
        result = 31 * result + popularity.hashCode()
        result = 31 * result + video.hashCode()
        result = 31 * result + voteAverage.hashCode()
        result = 31 * result + voteCount
        result = 31 * result + backdropPath.hashCode()
        result = 31 * result + genreIds.contentHashCode()
        result = 31 * result + originalLanguage.hashCode()
        result = 31 * result + originalTitle.hashCode()
        result = 31 * result + overview.hashCode()
        result = 31 * result + posterPath.hashCode()
        result = 31 * result + releaseDate.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }
}