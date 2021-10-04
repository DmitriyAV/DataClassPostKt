package kotlinPost.wallServesesClass

import kotlinPost.*
import kotlinPost.dataClass.Post
import org.junit.Test

import org.junit.Assert.*

class WallServicesTest {

    @Test
    fun create() {
        val service = WallServices

         service.add(Post(
             id = 0,
             ownerId = 14124,
             fromId = 12312,
             createdBy = 1231,
             date = 21,
             text = text,
             replyOwnerId = 2123,
             replyPostId = 14112,
             friendsOnly = true,
             comments = comments,
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

        val result = Post(
            id = 0,
            ownerId = 14124,
            fromId = 12312,
            createdBy = 1231,
            date = 21,
            text = text,
            replyOwnerId = 2123,
            replyPostId = 14112,
            friendsOnly = true,
            comments = comments,
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

        assertEquals( Post( id = 0,
            ownerId = 14124,
            fromId = 12312,
            createdBy = 1231,
            date = 21,
            text = text,
            replyOwnerId = 2123,
            replyPostId = 14112,
            friendsOnly = true,
            comments = comments,
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

    @Test
    fun update() {

        val serv = WallServices

        serv.add( Post(
            3, 3, 1, 2, 1, text, 2, 1,
            true, comments, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        serv.add( Post(
            1, 3, 2, 1, 1, text, 2, 1,
            true, comments, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val update = ( Post(
            1, 3, 2, 1, 1, text, 2, 1,
            true, comments, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val result = serv.update(update)

        assertTrue(result)
    }

    @Test
    fun update_false(){
        val serv = WallServices

        serv.add( Post(
            3, 3, 1, 2, 1, text, 2, 1,
            true, comments, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        serv.add( Post(
            1, 3, 2, 1, 1, text, 2, 1,
            true, comments, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val update = ( Post(
            31, 3, 1, 1, 1, text, 2, 1,
            true, comments, copyright, likes, repost, view, copyright.type, 2, false,
            true, false, false, true, false, donut, 1
        ))

        val result = serv.update(update)

        assertFalse(result)
    }
}