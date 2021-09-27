package kotlinPost.dataClass

class Comments(

    val canPost: Boolean,
    //(integer, [0,1]) — информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
    val groupsCanPost: Boolean,
    //(integer, [0,1]) — информация о том, могут ли сообщества комментировать запись;
    val canClose: Boolean,
    //(boolean) — может ли текущий пользователь закрыть комментарии к записи;
    val canOpen: Boolean,
    //(boolean) — может ли текущий пользователь открыть комментарии к записи.
) {
    private val count: Int = (0..100).random()

    @Override
    override fun toString(): String {
        return "${isCommentOp(canOpen)}, ${isCommentCl(canClose)}, ${isCommentGr(groupsCanPost)}, ${isCommentPos(canPost)} "
    }

    private fun isCommentOp(canOp: Boolean): String {
        val comment = when {
            canOp -> return "Can open comments"
            else -> "Disable to comment"
        }
        return comment
    }

    private fun isCommentCl(canClo: Boolean): String {
        val comment = when {
            canClo -> return "Can close comments"

            else -> "Disable to comments"
        }
        return comment
    }

    private fun isCommentGr(grCanPos: Boolean): String {
        val comment = when {
            grCanPos -> return "Group can post comments"

            else -> "Disable to comments"
        }
        return comment
    }

    private fun isCommentPos(canPos: Boolean): String {
        val comment = when {
            canPos -> return "Can post comment"

            else -> "Disable to comments"
        }
        return comment
    }


    private fun canComment(str: String): String {
        return if (str === "Disable to comments") str else {
            "Quantity of comment's is: $count"
            str
        }
    }
}
/*
    private fun isComent(canOp: Boolean, canClo: Boolean, grCanPos: Boolean, canPos: Boolean): String {
        val comment = when {
            canOp -> return "Can open comments."
            canClo -> return "Can close comments."
            grCanPos -> return "Group can post comments"
            canPos -> return "Can post comment"

            else -> "Disable to comments"
        }
        return comment
    }

    private fun canComment(str: String): String {
        return if (str === "Disable to comments") str else {
            "Quantity of comment's is: $count $str"
        }
    }*/

/*

private fun isCommentOp(canOp: Boolean): String {
    val comment = when {
        canOp -> return "Can open comments."
        else -> "Disable to comment"
    }
    return comment
}
private fun isCommentCl( canClo: Boolean ): String {
    val comment = when {
        canClo -> return "Can close comments."

        else -> "Disable to comments"
    }
    return comment
}
private fun isCommentGr(grCanPos: Boolean): String {
    val comment = when {
        grCanPos -> return "Group can post comments"

        else -> "Disable to comments"
    }
    return comment
}
private fun isCommentPos(canPos: Boolean): String {
    val comment = when {
        canPos -> return "Can post comment"

        else -> "Disable to comments"
    }
    return comment
}



private fun canComment(str: String): String{
    return if (str === "Disable to comments") str else {
        "Quantity of coment's is: $count"
        str
    }
}*/
