package kotlinPost.dataClass

import kotlinPost.attachment.*

data class Comment(
    val id: Int, //integer идентификатор комментария.
    val fromId: Int, //integer идентификатор автора комментария.
    val date: Int, //integer	дата создания комментария в формате Unixtime.
    val message: String, //string текст комментария.
    val donut: Donut, //object информация о VK Donut. Объект со следующими полями:
    var replyToUser: Int?, //integer	идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
    var replyToComment: Int?, //integer	идентификатор комментария, в ответ на который оставлен текущий (если применимо).
    val attachments: Attachments, //object медиа вложения комментария (фотографии, ссылки и т.п.). Описание массива attachments находится на отдельной странице.
    var parentsStack: Array<Int>, //array массив идентификаторов родительских комментариев.
    val thread: Thread, //object	Информация о вложенной ветке комментариев, объект с полями:
    val canPost: Boolean, //(integer, [0,1]) — информация о том, может ли текущий пользователь комментировать запись (1 — может, 0 — не может);
    val groupsCanPost: Boolean, //(integer, [0,1]) — информация о том, могут ли сообщества комментировать запись;
    val canClose: Boolean, //(boolean) — может ли текущий пользователь закрыть комментарии к записи;
    val canOpen: Boolean, //(boolean) — может ли текущий пользователь открыть комментарии к записи.

) {

    override fun toString(): String {
        return "Comment to post #$id from author #$fromId, \n" +
                "posted at $date, \n" +
                "Text: ($message) \n" +
                "Comments from donut: $donut. \n" +
                "Comments reply to User: #$replyToUser. " +
                "Comment reply: #$replyToComment.\n" +
                "Attachments of comments: ${resultAttach(attachments)} \n" +
                "Parents Comments: ${printArray(parentsStack)} \n" +
                "Thread of them: $thread" +
                "${isCommentOp(canOpen)}, ${isCommentCl(canClose)}," +
                " ${isCommentGr(groupsCanPost)}, ${isCommentPos(canPost)}"
    }
}

fun resultAttach(attachments: Attachments): Any {
    return when (attachments) {
        is Attachments.AudioAtt -> attachesAdd(attachments.audio)
        is Attachments.VideoAtt -> attachesAdd(attachments.video)
        is Attachments.DocAtt -> attachesAdd(attachments.doc)
        is Attachments.LinkAtt -> attachesAdd(attachments.link)
        is Attachments.PhotoAtt -> attachesAdd(attachments.photo)
    }
}

private fun attachesAdd(attachments: Any): Any {
    var attaches = emptyArray<Any>()
    attaches += attachments
    return attaches.last()
}

private fun printArray(parents: Array<Int>) {
    for (parent in parents) {
        println(parent.toString())
    }
}

val count: Int = 0
private val disable: String = "Disable to comments"


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
