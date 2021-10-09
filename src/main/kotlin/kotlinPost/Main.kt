package kotlinPost

import kotlinPost.attachment.*
import kotlinPost.dataClass.*
import kotlinPost.wallServesesClass.WallServices


private var copyrightRandom: Int = (0..10).random()
private var viewRandom: Int = (0..100).random()
private var dateRandom: Int = (0..48).random()


val comments = Comments(true, true, true, true)
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


fun main() {
    val serves = WallServices

    val post = Post(2, 2, 3, 4, dateRandom, text, 5, 6,
        false, comments, copyright, likes, repost, view, copyright.type, 7, false,
        true, false, false, true, false, donut, 8)

    val post1 = Post(2, 11, 12, 13, dateRandom, text, 14, 15,
        true, comments, copyright, likes, repost, view, copyright.type, 16, true,
        true, false, true, false, false, donut, 17)

    val post2 = Post(2, 21, 22, 23, dateRandom, text, 24, 25,
        true, comments, copyright, likes, repost, view, copyright.type, 26, true,
        false, false, false, true, true, donut, 27)

    val post3 = Post(4, 211, 221, 231, dateRandom, text, 24, 25,
        true, comments, copyright, likes, repost, view, copyright.type, 26, true,
        false, false, false, true, true, donut, 28)


    val comment = Comment(4, 2, 3, "New Comment", donut, 1, 1, Attachments.AudioAtt(audioAttach), arrayParent, thread)

    serves.add(post)
    serves.add(post1)
    serves.add(post2)
    serves.print()
    serves.update(post3)
    serves.addComment(comment)
    serves.printComment()
}


