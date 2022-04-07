package ru.netology

import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {


    @Test
    fun add() {
        val service = WallService

        val result = service.add(Post(text = "Пост7"))

        assertEquals(result.id, 7)
    }


    @Test
    fun updateExistingTrue() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        service.add(Post(text = "Пост1"))
        service.add(Post(text = "Пост2"))
        service.add(Post(text = "Пост3"))
        // создаём информацию об обновлении
        val update = Post(id = 2, text = "Редактирование Поста 2")

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateExistingFalse() {
        // создаём целевой сервис
        val service = WallService
        // заполняем несколькими постами
        service.add(Post(text = "Пост1"))
        service.add(Post(text = "Пост2"))
        service.add(Post(text = "Пост3"))
        // создаём информацию об обновлении
        val update = Post(id = 5, text = "Редактирование Поста 2")

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test
    fun likePostIdTrue() {
        val service = WallService

        val result = service.likePostId(3)
        assertTrue(result)
    }

    @Test
    fun likePostIdFalse() {
        val service = WallService

        val result = service.likePostId(11)
        assertFalse(result)
    }

    @Test
    fun repostIdTrue() {
        val service = WallService

        val result = service.repostId(1)
        assertTrue(result)
    }

    @Test
    fun repostIdFalse() {
        val service = WallService

        val result = service.repostId(11)
        assertFalse(result)
    }

}