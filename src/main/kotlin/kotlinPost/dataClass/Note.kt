package kotlinPost.dataClass

data class Note(
    override val id: Int, //integer идентификатор комментария.
    override val fromId: Int, //integer идентификатор автора комментария.
    override val date: Int, //integer	дата создания комментария в формате Unixtime.
     val message: String, //string текст комментария.
    val title: String, //заголовок заметки.
    var comment: Comment? // Комментарий к Заметке

) : Element(id, fromId, date) {

    var delNoteList = mutableListOf<Note>()
    var noteList = mutableListOf<Note>()
    var commentNote = mutableListOf<Comment>()
    var delCommentNoteList = mutableListOf<Comment>()

    override fun toString(): String {
        return " Note under id#$id, from user under id#$fromId, \n" +
                "Date of published note :$date \n" +
                "Title: $title \n" +
                "kotlinPost.dataClass.dt_directmasseges.Message: $message \n" +
                "Comment: $comment"
    }
}