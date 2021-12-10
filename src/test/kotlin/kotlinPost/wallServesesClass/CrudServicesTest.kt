package kotlinPost.wallServesesClass

import kotlinPost.*
import kotlinPost.attachment.Attachments
import kotlinPost.dataClass.Comment

import kotlinPost.dataClass.Post
import kotlinPost.excaption.PostNotFoundException
import org.junit.Test

import org.junit.Assert.*

class CrudServicesTest {

    @Test
    fun create() {
        val service = WallService

        val expectedPost = Post(
             id = 0,
             ownerId = 14124,
             fromId = 12312,
             createdBy = 1231,
             date = 21,
             message = text,
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

        service.add(expectedPost)

        val result = service.getById(expectedPost.id)

        assertEquals(result, expectedPost)

    }

    @Test (expected = PostNotFoundException::class)
    fun get() {
        val arrayParent = arrayOf(5)
        val ser = CommentService
        val serv = WallService

        ser.add( Comment(2, 2, 3, "New Comment", donut, 1, 1,
        Attachments.AudioAtt(audioAttach), arrayParent, thread, true, true, true, true))


        serv.add(Post(
            4, 211, 221, 231, 1, text, 24, 25,
            true, comment, copyright, likes, repost, view, copyright.type, 26, true,
            false, false, false, true, true, donut, 28))

        val comm = (Comment(3, 2, 3, "New Comment", donut, 1,
            1, Attachments.AudioAtt(audioAttach) , arrayParent , thread, true, true, true, true))

        serv.addComment(comm)
        serv.getById(comm.id)
    }

    @Test
    fun addComments() {
        val ser = WallService
        val result =  Post(
            3, 3, 1, 2, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        )

        ser.add(result)

        ser.add(Post(
            4, 211, 221, 231, 1, text, 24, 25,
            true, comment, copyright, likes, repost, view, copyright.type, 26, true,
            false, false, false, true, true, donut, 28))

        val comm = (Comment(3, 2, 3, "New Comment", donut, 1,
            1, Attachments.AudioAtt(audioAttach) , arrayParent , thread, true, true, true, true))

        ser.addComment(comm)

        assertEquals(ser.getById(result.id), ser.getById(comm.id))

    }

    @Test
    fun update() {

        val serv = WallService

        serv.add( Post(
            3, 3, 1, 2, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        serv.add( Post(
            1, 3, 2, 1, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val update = ( Post(
            1, 3, 4, 8, 6, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val result = serv.updatePost(update)

        assertTrue(result)
    }

    @Test
    fun update_false(){
        val serv = WallService

        serv.add( Post(
            3, 3, 1, 2, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        serv.add( Post(
            1, 3, 2, 1, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val update = ( Post(
            31, 3, 1, 1, 1, text, 2, 1,
            true, comment, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val result = serv.updatePost(update)

        assertFalse(result)
    }
}