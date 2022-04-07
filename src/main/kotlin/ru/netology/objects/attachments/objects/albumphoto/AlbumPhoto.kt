package ru.netology.objects.attachments.objects.albumphoto

data class AlbumPhoto(
    val id: Int = 0,
    val thumb: Any? = null,
    val ownerId: Int = 0,
    val title: String? = null,
    val description: String? = null,
    val create: Int = 0,
    val update: Int = 0,
    val size: Int = 0
)