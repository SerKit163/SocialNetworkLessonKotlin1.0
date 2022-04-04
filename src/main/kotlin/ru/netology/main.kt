package ru.netology

import ru.netology.objects.Likes
import ru.netology.objects.Repost


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

    println("----------------")
    for (i in WallService.posts) {
        println("FOR -> " + i)
    }
    println("----------------")
}


object WallService {
    var posts = emptyArray<Post>()
    private var id: Int = 0

    fun add(post: Post): Post {
        id++
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
//                posts[p.id - 1] = p.copy(reposts = Repost(count = countRepost))
                val repostPost = p.copy(reposts = Repost(userReposted = true, idPostOriginal = p.id), likes = null)
                add(repostPost)
                return true
            }
        }
        return false
    }
}
