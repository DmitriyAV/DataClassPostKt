package kotlinPost.wallServesesClass

import kotlinPost.attachment.*
import kotlinPost.dataClass.Comment
import kotlinPost.dataClass.Post
import kotlinPost.excaption.PostNotFoundException

object WallServices {
    private var posts = emptyArray<Post>()

    private var comments = emptyArray<Comment>()


    fun add(posted: Post): Post {
        posts += posted
        for (post in posts) {
            if (posts.isNotEmpty()) posts.last().id + 1
        }
        return posts.last()
    }


    fun addComment(comment: Comment): Comment {
        comment.id + 1
        for (post in posts) {
            if (posts.isNotEmpty()) comment.id + 1
            if (comment.id == post.id) comments += comment
            else throw PostNotFoundException("$comment is not found in post!")
        }
        return comments.last()
    }

    /*fun type(attach: Attachment) {
        when (attach) {
            is AudioAttach -> attachesAdd(attach)
            is DocAttach -> attachesAdd(attach)
            is LinkAttach -> attachesAdd(attach)
            is PhotoAttach -> attachesAdd(attach)
            is VideoAttach -> attachesAdd(attach)
        }
    }*/

    fun print() {
        println(posts.last()).toString()
    }

    fun printComment(){
        println(comments.last().toString())
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