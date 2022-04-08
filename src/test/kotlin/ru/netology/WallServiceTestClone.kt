package ru.netology

import org.junit.Test

import org.junit.Assert.*
import ru.netology.exceptions.CommentNotFoundException
import ru.netology.exceptions.PostNotFoundException
import ru.netology.exceptions.ReportCommentNotFoundException
import ru.netology.objects.comments.Comment

class WallServiceTestClone {

    val service = WallService
    val post = service.add(Post(text = "Пост"))
    val update = Post(id = 1, text = "Редактирование Поста 1")
    val updateNotId = Post(id = 99, text = "Редактирование Поста 1")
    val comment = Comment(id = 1, postId = 1, text = "Комментарий #1 к посту #1")
    val commentNotId = Comment(id = 1, postId = 99, text = "Комментарий #1 к посту #1")
    val createComment = service.createComment(comment)


    @Test
    fun add() {
        assertEquals(post.id, 1)
    }


    @Test
    fun updateExistingTrue() {
        // выполняем целевое действие
        val result = service.update(update)
        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateExistingFalse() {
        // выполняем целевое действие
        val result = service.update(updateNotId)
        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test
    fun likePostIdTrue() {
        val result = service.likePostId(1)
        assertTrue(result)
    }

    @Test
    fun likePostIdFalse() {
        val result = service.likePostId(99)
        assertFalse(result)
    }

    @Test
    fun repostIdTrue() {
        val result = service.repostId(1)
        assertTrue(result)
    }

    @Test
    fun repostIdFalse() {
        val result = service.repostId(99)
        assertFalse(result)
    }

    @Test
    fun createComment() {
//        val result = service.createComment(comment)
        assertEquals(createComment, comment)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowCreateComment() {
        val result = service.createComment(commentNotId)
        assertEquals(result, Comment(id = 1, postId = 99, text = "Комментарий #1 к посту #2"))
    }

    @Test
    fun reportComment() {
        val result = service.reportComment(1, 0)
        assertEquals(result.reportComment, "Спам")
    }

    @Test(expected = CommentNotFoundException::class)
    fun shouldThrowReportCommentPost() {
        val result = service.reportComment(99, 0)
        assertEquals(result.reportComment, "Спам")

    }

    @Test(expected = ReportCommentNotFoundException::class)
    fun shouldThrowReportCommentReason() {
        val result = service.reportComment(1, 99)
        assertEquals(result.reportComment, "Спам")

    }







//    @Test
//    fun add() {
//        val service = WallService
//
//        val result = service.add(Post(text = "Пост7"))
//
//        assertEquals(post.id, 1)
//    }
//
//
//    @Test
//    fun updateExistingTrue() {
//        // создаём целевой сервис
////        val service = WallService
//        // заполняем несколькими постами
//        service.add(Post(text = "Пост1"))
//        service.add(Post(text = "Пост2"))
//        service.add(Post(text = "Пост3"))
//        // создаём информацию об обновлении
//        val update = Post(id = 2, text = "Редактирование Поста 2")
//
//        // выполняем целевое действие
//        val result = service.update(update)
//
//        // проверяем результат (используйте assertTrue или assertFalse)
//        assertTrue(result)
//    }
//
//    @Test
//    fun updateExistingFalse() {
//        // создаём целевой сервис
//        val service = WallService
//        // заполняем несколькими постами
//        val post = service.add(Post(text = "Пост1"))
//        // создаём информацию об обновлении
//        val update = Post(id = post.id + 10, text = "Редактирование Поста 1")
//
//        // выполняем целевое действие
//        val result = service.update(update)
//
//        // проверяем результат (используйте assertTrue или assertFalse)
//        assertFalse(result)
//    }
//
//    @Test
//    fun likePostIdTrue() {
//        val service = WallService
//
//        val result = service.likePostId(3)
//        assertTrue(result)
//    }
//
//    @Test
//    fun likePostIdFalse() {
//        val service = WallService
//
//        val result = service.likePostId(99)
//        assertFalse(result)
//    }
//
//    @Test
//    fun repostIdTrue() {
//        val service = WallService
//
//        val result = service.repostId(1)
//        assertTrue(result)
//    }
//
//    @Test
//    fun repostIdFalse() {
//        val service = WallService
//
//        val result = service.repostId(11)
//        assertFalse(result)
//    }
//
//    @Test
//    fun createComment() {
//        val service = WallService
//
//        service.add(Post(text = "Пост8"))
//
//        val comment = Comment(id = 3, postId = 1, text = "Комментарий #1 к посту #2")
//
//        val result = service.createComment(comment)
//
//        assertEquals(result, comment)
//    }
//
//    @Test(expected = PostNotFoundException::class)
//    fun shouldThrowCreateComment() {
//        val service = WallService
//
//        service.add(Post(text = "Пост8"))
//        service.add(Post(text = "Пост9"))
//
//        val comment = Comment(id = 1, postId = 99, text = "Комментарий #1 к посту #2")
//
//        val result = service.createComment(comment)
//
//        assertEquals(result, Comment(id = 1, postId = 99, text = "Комментарий #1 к посту #2"))
//    }
//
//    @Test
//    fun reportComment() {
//        val service = WallService
//        val post = service.add(Post(text = "Пост10"))
//
//        val comment = Comment(id = 1, postId = post.id, text = "Комментарий #1 к посту #11")
//        service.createComment(comment)
//
//        val result = service.reportComment(4, 0)
//        assertEquals(result.reportComment, "Спам")
//
//    }
//
//    @Test(expected = CommentNotFoundException::class)
//    fun shouldThrowReportCommentPost() {
//        val service = WallService
//        service.add(Post(text = "Пост11"))
//
//        val comment = Comment(id = 1, postId = 1, text = "Комментарий #1 к посту #11")
//        service.createComment(comment)
//
//        val result = service.reportComment(111, 0)
//        assertEquals(result.reportComment, "Спам")
//
//    }
//
//    @Test(expected = ReportCommentNotFoundException::class)
//    fun shouldThrowReportCommentReason() {
//        val service = WallService
//        service.add(Post(text = "Пост12"))
//
//        val comment = Comment(id = 1, postId = 1, text = "Комментарий #1 к посту #12")
//        service.createComment(comment)
//
//        val result = service.reportComment(1, 10)
//        assertEquals(result.reportComment, "Спам")
//
//    }

}