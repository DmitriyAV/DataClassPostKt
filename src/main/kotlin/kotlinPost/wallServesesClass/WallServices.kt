package kotlinPost.wallServesesClass

import kotlinPost.attachment.*
import kotlinPost.dataClass.Post

object WallServices {
    private var posts = emptyArray<Post>()
    private var attaches = emptyArray<Attachment>()

    fun add(posted: Post): Post {
        posts += posted
        for (post in posts) {
            if (posts.isNotEmpty()) posts.last().id + 1
        }
        return posts.last()
    }

    private fun attachesAdd(attach: Attachment): Attachment {
        attaches += attach
        return attaches.last()
    }

    fun printAttaches() {
        println(attaches.last().toString())
    }

    fun type(attach: Attachment){
        when (attach) {
            is AudioAttach -> attachesAdd(attach)
            is DocAttach -> attachesAdd(attach)
            is LinkAttach -> attachesAdd(attach)
            is PhotoAttach -> attachesAdd(attach)
            is VideoAttach -> attachesAdd(attach)
        }
    }

    fun print() {
        println(posts.last()).toString()
        println()
    }

    fun update(post: Post): Boolean {
        for ((index, postInPosts) in posts.withIndex()) {
            if (postInPosts.id == post.id) {
                posts[index] = post.copy(id = postInPosts.id, date = postInPosts.date)
                return true
            }
        }
        return false
    }

}