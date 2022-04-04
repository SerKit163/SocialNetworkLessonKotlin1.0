package ru.netology.objects

import ru.netology.Post

data class Repost(
    val count: Int = 0,
    val idPostOriginal: Int = 0,
    val userReposted: Boolean = false,
//    val originalPost: Post? = null
)