package ru.netology.objects

import java.time.LocalDateTime

data class PostSource(
    val type: String? = null,
    val platform: String? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val url: String? = null
)
