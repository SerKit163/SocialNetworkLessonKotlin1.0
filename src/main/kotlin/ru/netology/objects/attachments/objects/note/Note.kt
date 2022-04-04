package ru.netology.objects.attachments.objects.note

import java.time.LocalDateTime

data class Note(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String? = null,
    val text: String? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val comments: Int = 0,
    val readComments: Int = 0,
    val viewUrl: String? = null,
    val canComment: Int = 0,
    val textWiki: String? = null
)