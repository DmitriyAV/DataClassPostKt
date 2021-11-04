package kotlinPost.wallServesesClass

import kotlinPost.comment
import kotlinPost.dataClass.Comment
import kotlinPost.dataClass.Post

class WallService : WallServices<Post>() {


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
                element.id == token.id -> element.commentList += element
               // element.id == token.id -> token.copy(comments = element)
               // element.id == token.id -> element.commentList.last().id + 1
            }
        }
    }

}