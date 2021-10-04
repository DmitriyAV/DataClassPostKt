package kotlinPost

import kotlinPost.attachment.AudioAttach
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


fun main() {
    val serves = WallServices

    val post = Post(1, 2, 3, 4, dateRandom, text, 5, 6,
        false, comments, copyright, likes, repost, view, copyright.type, 7, false,
        true, false, false, true, false, donut, 8)

    val post1 = Post(1, 11, 12, 13, dateRandom, text, 14, 15,
        true, comments, copyright, likes, repost, view, copyright.type, 16, true,
        true, false, true, false, false, donut, 17)

    val post2 = Post(1, 21, 22, 23, dateRandom, text, 24, 25,
        true, comments, copyright, likes, repost, view, copyright.type, 26, true,
        false, false, false, true, true, donut, 27)

    val post3 = Post(4, 211, 221, 231, dateRandom, text, 24, 25,
        true, comments, copyright, likes, repost, view, copyright.type, 26, true,
        false, false, false, true, true, donut, 28)

    serves.add(post)
    serves.add(post1)
    serves.add(post2)
    serves.print()
    serves.update(post3)
    serves.print()
    serves.type(AudioAttach())
    serves.printAttaches()
}


