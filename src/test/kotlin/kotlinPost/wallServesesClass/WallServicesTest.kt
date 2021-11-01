package kotlinPost.wallServesesClass

import kotlinPost.*
import kotlinPost.attachment.Attachments
import kotlinPost.dataClass.Comment
import kotlinPost.dataClass.E
import kotlinPost.excaption.PostNotFoundException
import org.junit.Test

import org.junit.Assert.*

class WallServicesTest {

    @Test
    fun create() {
        val service = WallServices

         service.add(E(
             id = 0,
             ownerId = 14124,
             fromId = 12312,
             createdBy = 1231,
             date = 21,
             text = text,
             replyOwnerId = 2123,
             replyPostId = 14112,
             friendsOnly = true,
             comments = comment,
             copyright = copyright,
             likes = likes,
             reposts = repost,
             views = view,
             postType = copyright.type,
             signerId = 1124,
             canPin = true,
             canDelete = false,
             canEdit = false,
             isPinned = false,
             markedAsAds = true,
             isFavorite = false,
             donut = donut,
             postponedId = 12314
         ))

        val result = E(
            id = 0,
            ownerId = 14124,
            fromId = 12312,
            createdBy = 1231,
            date = 21,
            text = text,
            replyOwnerId = 2123,
            replyPostId = 14112,
            friendsOnly = true,
            comments = comment,
            copyright = copyright,
            likes = likes,
            reposts = repost,
            views = view,
            postType = copyright.type,
            signerId = 1124,
            canPin = true,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = true,
            isFavorite = false,
            donut = donut,
            postponedId = 12314
        )

        assertEquals( E( id = 0,
            ownerId = 14124,
            fromId = 12312,
            createdBy = 1231,
            date = 21,
            text = text,
            replyOwnerId = 2123,
            replyPostId = 14112,
            friendsOnly = true,
            comments = comment,
            copyright = copyright,
            likes = likes,
            reposts = repost,
            views = view,
            postType = copyright.type,
            signerId = 1124,
            canPin = true,
            canDelete = false,
            canEdit = false,
            isPinned = false,
            markedAsAds = true,
            isFavorite = false,
            donut = donut,
            postponedId = 12314), result )

    }

    @Test (expected = PostNotFoundException::class)
    fun get() {

        val ser = WallServices

        ser.add( E(
            3, 3, 1, 2, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))


        ser.add(E(
            4, 211, 221, 231, 1, text, 24, 25,
            true, comment, copyright, likes, repost, view, copyright.type, 26, true,
            false, false, false, true, true, donut, 28))

        val comm = (Comment(4, 2, 3, "New Comment", donut, 1,
            1, Attachments.AudioAtt(audioAttach) , arrayParent , thread, true, true, true, true))

        ser.addComment(comm)
        ser.get(comm.id)
    }
    @Test
    fun addComment() {
        val ser = WallServices

        ser.add( E(
            3, 3, 1, 2, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))


        ser.add(E(
            4, 211, 221, 231, 1, text, 24, 25,
            true, comment, copyright, likes, repost, view, copyright.type, 26, true,
            false, false, false, true, true, donut, 28))

        val comm = (Comment(3, 2, 3, "New Comment", donut, 1,
            1, Attachments.AudioAtt(audioAttach) , arrayParent , thread, true, true, true, true))

        ser.addComment(comm)
    }

    @Test
    fun update() {

        val serv = WallServices

        serv.add( E(
            3, 3, 1, 2, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        serv.add( E(
            1, 3, 2, 1, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val update = ( E(
            1, 3, 4, 8, 6, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val result = serv.update(update)

        assertTrue(result)
    }

    @Test
    fun update_false(){
        val serv = WallServices

        serv.add( E(
            3, 3, 1, 2, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        serv.add( E(
            1, 3, 2, 1, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val update = ( E(
            31, 3, 1, 1, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val result = serv.update(update)

        assertFalse(result)
    }
}