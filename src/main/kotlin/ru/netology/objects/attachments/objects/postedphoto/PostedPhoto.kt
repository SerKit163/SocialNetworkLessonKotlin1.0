package ru.netology.objects.attachments.objects.postedphoto

data class PostedPhoto(
    val id: Int = 0,
    val owner: Int = 0,
    val photo130: String? = null,
    val photo604: String? = null
)