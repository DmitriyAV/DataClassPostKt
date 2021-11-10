package kotlinPost.wallServesesClass

import kotlinPost.dataClass.Comment
import kotlinPost.dataClass.Note
import kotlinPost.excaption.PostNotFoundException


object NoteService  {
    var commentNote = mutableListOf<Comment>()
    var delCommentNoteList = mutableListOf<Comment>()
    var noteList = mutableListOf<Note>()
    var delNoteList = mutableListOf<Note>()

    fun add(element: Note): Note {
        this.noteList += element
        return this.noteList.last()
    }

    fun delete(elem: Note): Note {
        delNoteList += elem
        this.noteList.remove(elem)
        return delNoteList.last()
    }

    fun getById(id: Int): Note {
        return this.noteList.find { it.id == id } ?: throw PostNotFoundException("Comment by id #$id is not found in post!")
    }

    fun get(): List<Note> {
        return this.noteList.sortedBy { it.date }
    }

    fun print() {
        println(this.noteList.last()).toString()
    }

    fun updateNote(note: Note): Boolean {
        for ((index, noteInNotes) in this.noteList.withIndex()) {
            if (noteInNotes.id == note.id) {
                this.noteList[index] = note.copy(id = noteInNotes.id, date = note.date)
                return true
            }
        }
        return false
    }

    fun deleteComment(note: Note, comment: Comment) {
        if (note.id == comment.id) {
            delCommentNoteList += comment
            commentNote.remove(comment)
        } else getById(comment.id)
    }

    fun addComment(note: Note, element: Comment) {
        for (token in this.noteList) {
            when (this.noteList.isNotEmpty()) {
                element.id == token.id -> commentNote.add(element)
                element.id == token.id -> token.comment = element
                //element.id == token.id -> note.commentNote.last().id + 1
            }
        }
    }

    fun restoreComment(comment: Comment){
        for (delToken in delNoteList) {
            when (delNoteList.isNotEmpty()) {
                comment.id == delToken.id -> this.noteList.add(delToken)
                else -> getById(comment.id)

            }
        }
    }
}