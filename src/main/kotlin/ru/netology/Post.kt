package ru.netology

import java.time.LocalDateTime

data class Post(
    val id: Int = 0, // id Поста
    val ownerId: Int = 0, // id
    val fromId: Int = 0, // id Пользователя
    val text: String, // Тест поста
    val likes: Int = 0, // Количество лайков поста
    val views: Int = 0, // Количество просмотра поста
    val friendsOnly: Boolean = false, // Видно только друзьям
    val date: LocalDateTime = LocalDateTime.now(), // Дата поста

)

