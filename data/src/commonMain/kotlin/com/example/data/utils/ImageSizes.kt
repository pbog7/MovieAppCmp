package com.example.data.utils

import com.example.data.utils.ImageSizeAlias.*
import com.example.domain.models.ImageType

val IMAGE_SIZES: Map<ImageType, Map<ImageSizeAlias, String>> = mapOf(
    ImageType.BACKDROP to mapOf(
        SMALL to "w300",
        MEDIUM to "w780",
        LARGE to "w1280",
        ORIGINAL to "original"
    ),
    ImageType.LOGO to mapOf(
        TINY to "w92",
        SMALL to "w185",
        MEDIUM to "w300",
        LARGE to "w500",
        ORIGINAL to "original"
    ),
    ImageType.POSTER to mapOf(
        TINY to "w185",
        SMALL to "w342",
        MEDIUM to "w500",
        LARGE to "w780",
        ORIGINAL to "original"
    ),
    ImageType.PROFILE to mapOf(
        SMALL to "w45",
        MEDIUM to "w185",
        LARGE to "h632",
        ORIGINAL to "original"
    ),
    ImageType.STILL to mapOf(
        SMALL to "w92",
        MEDIUM to "w185",
        LARGE to "w300",
        ORIGINAL to "original"
    )
)
fun getImageSizePath(type: ImageType, alias: ImageSizeAlias): String {
    return IMAGE_SIZES[type]?.get(alias) ?: "original"
}
