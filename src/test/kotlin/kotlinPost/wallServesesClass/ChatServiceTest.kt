package kotlinPost.wallServesesClass

import kotlinPost.dataClass.dt_directmasseges.Message
import kotlinPost.excaption.MessageNotFoundException
import kotlinPost.excaption.UserNotFoundException
import kotlinPost.title
import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    val chatService = DMService

    @Test
    fun deleteChatTrue() {

      val chatService = DMService
        val message = Message(3, 4, 2, title, true)
        chatService.addMessage(message)
        val result = chatService.deleteChat(3, 4)
        assertTrue(result)
    }

    @Test(expected = UserNotFoundException::class)
    fun shouldThrowDeleteChat() {
        Message(3, 4, 2, title, true)
        chatService.deleteChat(4, 3)
    }

    @Test
    fun changeMessage() {
        val message = Message(3, 4, 2, title, true)
        chatService.addMessage(message)
        val message3 = Message(4, 2, 3, title, false)
        val result = chatService.updateMessage(message, message3)
        assertTrue(result)
    }

    @Test
    fun deleteMessage() {
        val message = Message(3, 4, 2, title, true)
        chatService.addMessage(message)
        val result = chatService.deleteMessage(3, 4, 2)
        assertTrue(result)
    }

    @Test(expected = UserNotFoundException::class)
    fun shouldThrowDeleteMessage() {

         Message(3, 4, 2, title, true)
        chatService.deleteMessage(4, 3, 4)
    }

    @Test
    fun getUnreadMessageCount() {

        val message = Message(3, 4, 2, title, true)
        chatService.addMessage(message)
        val countExpected = 1
        val result = chatService.getUnreadChatsCount()
        assertEquals(countExpected, result)
    }

}