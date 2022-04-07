package ru.netology.objects.attachments.objects.photo

import ru.netology.objects.attachments.objects.photo.objects.PhotoSizes
import java.time.LocalDateTime

data class Photo(
    val id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0,
    val text: String? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val sizes: PhotoSizes? = null,
    val width: Int = 0,
    val height: Int = 0
)