package kotlinPost.wallServesesClass

import kotlinPost.dataClass.Comment

object CommentService : WallServices<Comment>() {

    fun deleteComment(comment: Comment) {
        getById(comment.id).commentList.remove(comment)
    }

    fun updateComment(comment: Comment): Boolean {
        for ((index, commentInComments) in elements.withIndex()) {
            if (commentInComments.id == comment.id) {
                getById(comment.id).commentList[index] = comment.copy(id = commentInComments.id, date = commentInComments.date)
                return true
            }
        }
        return false
    }
}