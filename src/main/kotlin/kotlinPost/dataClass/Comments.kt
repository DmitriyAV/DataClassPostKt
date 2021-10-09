package kotlinPost.dataClass

class Comments(
    val canPost: Boolean, //(integer, [0,1]) — информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
    val groupsCanPost: Boolean, //(integer, [0,1]) — информация о том, могут ли сообщества комментировать запись;
    val canClose: Boolean, //(boolean) — может ли текущий пользователь закрыть комментарии к записи;
    val canOpen: Boolean, //(boolean) — может ли текущий пользователь открыть комментарии к записи.

) {
    val count: Int = 0
    private val disable: String = "Disable to comments"


    @Override
    override fun toString(): String {
        return "${isCommentOp(canOpen)}, ${isCommentCl(canClose)}," +
                " ${isCommentGr(groupsCanPost)}, ${isCommentPos(canPost)}"
    }

    private fun isCommentOp(canOp: Boolean): String {
        val comment = when {
            canOp -> return "Can open comments"
            else -> disable
        }
        return comment
    }

    private fun isCommentCl(canClo: Boolean): String {
        val comment = when {
            canClo -> return "Can close comments"

            else -> disable
        }
        return comment
    }

    private fun isCommentGr(grCanPos: Boolean): String {
        val comment = when {
            grCanPos -> return "Group can post comments"

            else -> disable
        }
        return comment
    }

    private fun isCommentPos(canPos: Boolean): String {

        val comment = when {
            canPos -> return "Can post comment. \n" +
                    " Current comment quantity is $count"

            else -> disable
        }
        return comment
    }
}

