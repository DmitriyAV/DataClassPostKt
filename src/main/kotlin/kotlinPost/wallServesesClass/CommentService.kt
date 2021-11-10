package kotlinPost.wallServesesClass

import kotlinPost.dataClass.Comment
import kotlinPost.excaption.PostNotFoundException

object CommentService {
    var commentList = mutableListOf<Comment>()
    var deletedCommentList = mutableListOf<Comment>()

    fun add(element: Comment): Comment {
        commentList += element
        return commentList.last()
    }

    fun getById(id: Int): Comment {
        return commentList.find { it.id == id } ?: throw PostNotFoundException("Comment by id #$id is not found in post!")
    }

    fun get(): List<Comment> {
        return commentList.sortedBy { it.date }
    }

    fun print() {
        println(commentList.last()).toString()
    }

    fun deleteComment(comment: Comment) {
        commentList.forEach {
            if (comment.id == it.id) {
                deletedCommentList.add(it)
                commentList.remove(it)
            }
            else throw throw PostNotFoundException("Comment by id #${comment.id} is not found in post!")
        }
    }

    fun updateComment(comment: Comment): Boolean {
        for ((index, commentInComments) in commentList.withIndex()) {
            if (commentInComments.id == comment.id) {
               commentList[index] = comment.copy(id = commentInComments.id, date = commentInComments.date)
                return true
            }
        }
        return false
    }
}