package kotlinPost.dataClass

import kotlinPost.attachment.*

data class Comment(
   val id: Int, //integer идентификатор комментария.
   val fromId: Int, //integer идентификатор автора комментария.
   val date: Int, //integer	дата создания комментария в формате Unixtime.
   val text: String, //string текст комментария.
   val donut: Donut, //object информация о VK Donut. Объект со следующими полями:
   var replyToUser: Int?, //integer	идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
   var replyToComment: Int?, //integer	идентификатор комментария, в ответ на который оставлен текущий (если применимо).
   val attachments: Attachments, //object медиа вложения комментария (фотографии, ссылки и т.п.). Описание массива attachments находится на отдельной странице.
   var parentsStack: Array<Int>, //array массив идентификаторов родительских комментариев.
   val thread: Thread, //object	Информация о вложенной ветке комментариев, объект с полями:

) {

    override fun toString(): String {
        return "Comment to post #$id from author #$fromId, \n" +
                "posted at $date, \n" +
                "Text: ($text) \n" +
                "Comments from donut: ${donut.toString()}. \n" +
                "Comments reply to User: #$replyToUser}. " +
                "Comment reply: #$replyToComment}.\n" +
                "Attachments of comments: ${resultAttach(attachments).toString()} \n" +
                "Parents Comments: ${printArray(parentsStack)} \n" +
                "Thread of them: ${thread.toString()}"
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

private fun printArray(parents: Array<Int>){
    for (parent in parents){
        println(parent.toString())
    }
}
