package ru.netology

import ru.netology.objects.*
import ru.netology.objects.attachments.Attachments
import ru.netology.objects.comments.Comment
import ru.netology.objects.geo.Geo
import java.time.LocalDateTime

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    val text: String? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val replyOwnerId: Int = 0,
    val replyPostIf: Int = 0,
    val friendsOnly: Boolean = false,
    val comments : Comment? = null,
    val copyright: Copyright? = null,
    val likes: Likes? = null,
    val reposts: Repost? = null,
    val views: Views? = null,
    val postType: String? = null,
    val postSource: PostSource? = null,
    val attachments: Array<Attachments>? = null,
    val geo: Geo? = null,
    val signerId: Int = 0,
//    val copyHistory: Array<Any>? = null,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val donut: Donut? = null,
    val postponedId: Int = 0
)

