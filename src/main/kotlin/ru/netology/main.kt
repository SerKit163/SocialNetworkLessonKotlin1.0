package ru.netology


fun main() {

    val post1 = Post(text = "Пост #1", ownerId = 1)
    val post2 = Post(text = "Пост #2", ownerId = 4)
    val post3 = Post(text = "Пост #3", ownerId = 2)
    val post4 = Post(id = 7, text = "Пост #4", ownerId = 123) // Массив. Установить 7, но в будущем Автоматически уже не устанавливать 7
    val post5 = Post(id = 2, text = "Пост #5", fromId = 10) // Не установит, так как 2 уже есть в массиве
    val post6 = Post(text = "Пост #6", ownerId = 67)

    val upPost = Post(id = 5, text = "Редактированный Пост #2")

    WallService.add(post1)
    WallService.add(post2)
    WallService.add(post3)
    WallService.add(post4)
    WallService.add(post5)
    WallService.add(post6)

    WallService.update(upPost)


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
                posts.set(p.id - 1, post.copy(
                    text=post.text,
                    fromId = post.fromId,
                    likes = post.likes,
                    views = post.views,
                    friendsOnly = post.friendsOnly
                ))
            return true
            }
        }
        return false
    }
}