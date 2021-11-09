package kotlinPost.wallServesesClass

import kotlinPost.dataClass.Comment
import kotlinPost.dataClass.Note


object NoteService : WallServices<Note>() {

    fun updateNote(note: Note): Boolean {
        for ((index, noteInNotes) in elements.withIndex()) {
            if (noteInNotes.id == note.id) {
                elements[index] = note.copy(id = noteInNotes.id, date = note.date)
                return true
            }
        }
        return false
    }

    fun deleteComment(note: Note, comment: Comment) {
        if (note.id == comment.id) {
            note.delCommentNoteList += comment
            note.commentNote.remove(comment)
        } else getById(comment.id)
    }

    fun addComment(note: Note, element: Comment) {
        for (token in elements) {
            when (elements.isNotEmpty()) {
                element.id == token.id -> note.commentNote.add(element)
                element.id == token.id -> token.comment = element
                //element.id == token.id -> note.commentNote.last().id + 1
            }
        }
    }

    fun restoreComment(comment: Comment){
        for (delToken in deletedList) {
            when (deletedList.isNotEmpty()) {
                comment.id == delToken.id -> elements.add(delToken)
                else -> getById(comment.id)

            }
        }
    }
}