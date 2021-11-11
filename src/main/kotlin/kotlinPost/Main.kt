package kotlinPost

import User
import kotlinPost.attachment.*
import kotlinPost.dataClass.*
import kotlinPost.dataClass.dt_directmasseges.Message
import kotlinPost.wallServesesClass.CommentService
import kotlinPost.wallServesesClass.DMService
import kotlinPost.wallServesesClass.NoteService
import kotlinPost.wallServesesClass.WallService

private var copyrightRandom: Int = (0..10).random()
private var viewRandom: Int = (0..100).random()
private var dateRandom: Int = (0..48).random()


val donut = Donut(true, false)
val view = View(viewRandom)
val copyright = Copyright(copyrightRandom, "Link", "AuthorName", "Post")
val likes = Like(true)
val repost = Repost(true)
val text = null

val audioAttach = Audio("some track title", "some artist name", 5)
val videoAttach = Video("some video title", "some author name", 5)
val docAttach = Document("some document title", "some file content")
val linkAttach = Link("some link path")
val photoAttach = Photo("some photo title")
val thread = Thread(true, true, false)
val arrayParent = arrayOf(5)
val commentNew = Comment(2, 2, 3, "New Comment", donut, 1, 1,
    Attachments.AudioAtt(audioAttach), arrayParent, thread, true, true, true, true)
val comment: Comment? = null
val message: String = "Some sort of message."
val title: String = "Title of new Object."

fun main() {

    val wallServ = WallService
    val noteServ = NoteService
    val commServ = CommentService
    val dMServ = DMService

    val post = Post(3, 2, 3, 4, dateRandom, text, 5, 6,
        false, comment, copyright, likes, repost, view, copyright.type, 7, false,
        true, false, false, true, false, donut, 8)

    val post1 = Post(4, 11, 12, 13, dateRandom, text, 14, 15,
        true, comment, copyright, likes, repost, view, copyright.type, 16, true,
        true, false, true, false, false, donut, 17)

    val post2 = Post(2, 21, 22, 23, dateRandom, text, 24, 25,
        true, comment, copyright, likes, repost, view, copyright.type, 26, true,
        false, false, false, true, true, donut, 27)

    val post3 = Post(2, 211, 221, 231, dateRandom, text, 24, 25,
        true, comment, copyright, likes, repost, view, copyright.type, 26, true,
        false, false, false, true, true, donut, 28)

    val note = Note(1, 1, dateRandom, message, title, comment)
    val note1 = Note(2, 2, dateRandom, message, title, comment)
    val note2 = Note(3, 3, dateRandom, message, title, comment)
    val note3 = Note(2, 4, dateRandom, message, title, comment)

    val user = 2
    val user2 = 4
    val user4 = 3
    val user6 = 6

    val message = Message(4, 2, dateRandom, 1, title, true)
    val message2 = Message(3, 4, dateRandom, 2, title, true)
    val message3 = Message(4, 2, dateRandom, 3, title, false)
    val message4 = Message(2, 3, dateRandom, 10, title, true)
    val message5 = Message(4, 2, dateRandom, 5, title, true)
    val message6 = Message(3, 2, dateRandom, 6, title, true)

    /*   val user = User(2)
       val user2 = User(4)
       val user4 = User(3)
       val user6 = User(6)*/

    val chatService = DMService
/*
    chatService.addUsers(user)
    chatService.addUsers(user2)
    chatService.addUsers(user4)*/

    chatService.addMessage(message)
    chatService.addMessage(message2)
    chatService.addMessage(message3)
    chatService.addMessage(message5)
    chatService.addMessage(message6)
    chatService.getChats()
    println("Act some changes")
    println("______________________________________________________________")
    chatService.getMessage(user2)
    println("______________________________________________________________")
    chatService.getMessagesWithId(user2, 2, 1)
    println("______________________________________________________________")
    println("Unread chats is: ${chatService.getUnreadChatsCount()}")
    chatService.updateMessage(message3, message4)
    println("______________________________________________________________")
    chatService.deleteMessage(user4, user2, 2)
    chatService.deleteChat(user2, user)
    chatService.getChats()


    /*// Добавление Постов
    wallServ.add(post)
    wallServ.add(post1)
    wallServ.add(post2)
    wallServ.print()
    println("POST________________________")
    // Изменение поста
    wallServ.updatePost(post3)
    // Добавление комментария к посту
    wallServ.addComment(commentNew)
    wallServ.print()
    println("Added comment ${wallServ.getById(commentNew.id)}")
    println("Com to POST________________________")
    // Добавление Заметок
    noteServ.add(note)
    noteServ.add(note1)
    noteServ.add(note2)
    noteServ.print()
    println("NOTE________________________")
    // Добавление комментария к Заметке
    noteServ.addComment(note1, commentNew)
    println("Added comment ${noteServ.getById(commentNew.id)}")
    println("_________________________")
    noteServ.print()
    println("Com to NOTE________________________")
    // Удаление Заметки
    noteServ.delete(note2)
    // Изменение Заметки
    noteServ.updateNote(note3)
    noteServ.print()
    // Удаление заметки с комментарием
    noteServ.delete(note1)
    println("delete note________________________")
    noteServ.deleteComment(note1, commentNew)
    noteServ.print()*/
}


