package kotlinPost.wallServesesClass

import kotlinPost.dataClass.Comment
import kotlinPost.dataClass.Post
import kotlinPost.excaption.PostNotFoundException

object WallService {

    var elements = mutableListOf<Post>()
    val deletedList = mutableListOf<Post>()
    var commentList = mutableListOf<Comment>()

    fun add(element: Post): Post {
        elements += element
        return elements.last()
    }

    fun delete(elem: Post): Post {
        deletedList += elem
        elements.remove(elem)
        return deletedList.last()
    }

    fun getById(id: Int): Post {
        return elements.find { it.id == id } ?: throw PostNotFoundException("Comment by id #$id is not found in post!")
    }

    fun get(): List<Post> {
        return elements.sortedBy { it.date }
    }

    fun print() {
        println(elements.last()).toString()
    }

    fun updatePost(post: Post): Boolean {
        for ((index, postInPosts) in elements.withIndex()) {
            if (postInPosts.id == post.id) {
                elements[index] = post.copy(id = postInPosts.id, date = postInPosts.date)
                return true
            }
        }
        return false
    }

    fun addComment(element: Comment) {
        for (token in elements) {
            when (elements.isNotEmpty()) {
                element.id == token.id ->  commentList += element
               // element.id == token.id -> token.copy(comments = element)
               // element.id == token.id -> element.commentList.last().id + 1
            }
        }
    }

}