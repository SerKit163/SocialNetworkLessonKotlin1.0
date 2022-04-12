package ru.netology

import ru.netology.exceptions.CommentNotFoundException
import ru.netology.exceptions.PostNotFoundException
import ru.netology.exceptions.ReportCommentNotFoundException
import ru.netology.objects.Likes
import ru.netology.objects.Repost
import ru.netology.objects.comments.Comment


fun main() {

    val post1 = Post(text = "Пост #1", ownerId = 1)
    val post2 = Post(text = "Пост #2", ownerId = 4)
    val post3 = Post(text = "Пост #3", ownerId = 2)
    val post4 = Post(id = 7, text = "Пост #4", ownerId = 123) // Новое введенное id не меняет предыдущие
    val post5 = Post(text = "Пост #5", fromId = 10)
    val post6 = Post(text = "Пост #6", ownerId = 67)

    val upPost = Post(id = 5, text = "Редактированный Пост #2")

    WallService.add(post1)
    WallService.add(post2)
    WallService.add(post3)
    WallService.add(post4)
    WallService.add(post5)
    WallService.add(post6)

    WallService.update(upPost)

    WallService.likePostId(2)

    WallService.repostId(1)
    WallService.repostId(1)
    WallService.repostId(2)
    WallService.repostId(3)

    WallService.likePostId(1)
    WallService.likePostId(2)

//    val attachmentVideo: Attachment = Attachment.VideoAttachment(Video(type = "stuff"))
//    println(attachmentVideo.type)

    val comment1 = Comment(postId = 2, text = "Комментарий #1 к посту #2")
    val comment2 = Comment(postId = 5, text = "Комментарий #2 к посту #5")
//    val comment3 = Comment(postId = 20, text = "Комментарий #3 не существующего postId")

    WallService.createComment(comment1)
    WallService.reportComment(1, 4)
    WallService.createComment(comment2)
//    WallService.createComment(comment3)


    println("-- Комментария --")
    for (i in WallService.comments) {
        println("Comment -> $i")
    }
    println("-----------------")

    println("----- Посты -----")
    for (i in WallService.posts) {
        println("FOR -> $i")
    }
    println("-----------------")

}

object WallService {
    var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()

    private val reasonReportComment = arrayOf(
        "Спам",
        "Детская порнография",
        "Экстремизм",
        "Насилие",
        "Пропаганда наркотиков",
        "Материал для взрослых",
        "Оскорбление",
        "Призывы к суициду"
    )

    private var id: Int = 0
    private var commentId: Int = 0

    fun add(post: Post): Post {
        id++
//        posts += post.copy(id = if (post.id == 0) id else post.id)
        posts += post.copy(id = id)

        return posts.last()
    }

    fun update(post: Post): Boolean {

        posts.forEach { p ->
            if (p.id == post.id) {
                posts[p.id - 1] = post.copy(
                    text=post.text,
                    fromId = post.fromId,
                    likes = post.likes,
                    views = post.views,
                    friendsOnly = post.friendsOnly
                )
            return true
            }
        }
        return false
    }

    fun likePostId(id: Int): Boolean {
        posts.forEach { p ->
            if (p.id == id) {
                var countLike = p.likes?.count ?: 0
                countLike++

                val idPostOriginal = p.reposts?.idPostOriginal ?: 0

                if (idPostOriginal > 0) {
                    val original = posts[idPostOriginal - 1].likes?.count ?: 0
                    val sumLikes = original + 1

                    posts[idPostOriginal - 1] = posts[idPostOriginal - 1].copy(likes = Likes(count = sumLikes))
                }

                posts[p.id - 1] = p.copy(likes = Likes(count = countLike, userLikes = true))

            return true
            }
        }
        return false
    }

    fun repostId(id: Int): Boolean {
        posts.forEach { p ->
            if (p.id == id) {
                var countRepost = p.reposts?.count ?: 0
                countRepost++

                val originalLike = posts[id - 1].likes?.count ?: 0
                val sumLikes = originalLike + 1

                val idPostOriginal = p.reposts?.idPostOriginal ?: 0
                val userReposted = p.reposts?.userReposted ?: false

                if (idPostOriginal > 0) {
                    val original = posts[idPostOriginal - 1].likes?.count ?: 0
                    val sumLikesRepost = original + 1
                    posts[idPostOriginal - 1] = posts[idPostOriginal - 1].copy(likes = Likes(count = sumLikesRepost))
                }

                posts[p.id - 1] = p.copy(reposts = Repost(count = countRepost, idPostOriginal = idPostOriginal, userReposted = userReposted), likes = Likes(count = sumLikes))

                val repostPost = p.copy(reposts = Repost(userReposted = true, idPostOriginal = p.id), likes = null)
                add(repostPost)
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment): Comment {
        commentId++

        posts.forEach { p ->
            if (p.id == comment.postId) {
                comments += comment.copy(id = commentId)

                return comments.last()
            }
        }

        throw PostNotFoundException("Нет поста с id: ${comment.postId}")
    }

//    fun createComment(comment: Comment): Comment {
//        commentId++
//
//        val post = findPostId(comment.postId)
//
//        val commentPost = post?.copy(comments = Comment())
//            ?.comments?.copy(id = commentId, postId = comment.postId, text = comment.text)
//            ?: throw PostNotFoundException("Нет поста с id: ${comment.postId}")
//
//        comments += commentPost
//
//        posts[comment.postId - 1] = post.copy(comments = commentPost)
//
//        return comments.last()
//    }

    fun findPostId(id: Int): Post? {
        posts.forEach { post ->
            if (post.id == id) {
                return post
            }
        }
        return null
    }

    fun reportComment(id: Int, reason: Int): Comment {
        comments.forEach { c ->
            if (c.id == id) {
                if (reason < reasonReportComment.size) {
                    comments[c.id - 1] = c.copy(reportComment = reasonReportComment[reason])
                return comments.last()
                }
                throw ReportCommentNotFoundException("Нет жалобы с #: $reason")
            }
        }

        throw CommentNotFoundException("Нет комментария с id: $id")
    }
}
