package ru.netology.objects.attachments.objects.document

import java.time.LocalDateTime

data class Document(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String? = null,
    val size: Int = 0,
    val ext: String? = null,
    val date: LocalDateTime = LocalDateTime.now(),
)