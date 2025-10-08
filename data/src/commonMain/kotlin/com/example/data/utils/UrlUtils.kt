package com.example.data.utils

import com.example.domain.models.ImageType
import com.example.movieappcmp.BuildKonfig

object UrlUtils {
    fun buildImageUrl(
        path: String?,
        type: ImageType,
        size: ImageSizeAlias = ImageSizeAlias.MEDIUM
    ): String = if (path.isNullOrBlank()) "" else
        BuildKonfig.BASE_IMAGE_URL + getImageSizePath(type, size) + path
}
