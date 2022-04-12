package ru.netology.objects.comments

data class Comment(
    val id: Int = 0,
    val postId: Int = 0,
    val text: String? = null,
    val reportComment: String? = null
//    val fromId: Int = 0,
//    val count: Int = 0,
//    val canPost: Boolean = true,
//    val groupsCanPost: Boolean = true,
//    val canClose: Boolean = false,
//    val canOpen: Boolean = false
)