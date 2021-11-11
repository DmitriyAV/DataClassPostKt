package kotlinPost.wallServesesClass

import kotlinPost.dataClass.dt_directmasseges.Message
import kotlinPost.excaption.MessageNotFoundException
import kotlinPost.excaption.UserNotFoundException


object DMService {

    private var directMessage = mutableListOf<Message>()

    private fun isContains(userId: Int, fromId: Int): Boolean {
        if (directMessage.isNotEmpty()) {
            directMessage.forEach {
                return when (it.idUser == userId && it.fromId == fromId) {
                    true -> true
                    else -> false
                }
            }
        }
        return true
    }

    fun addMessage(message: Message) { directMessage += message }

    fun updateMessage(messageOld: Message, messageNew: Message) {
        if (isContains(messageOld.idUser, messageOld.fromId)) {
            directMessage.remove(messageNew)
            directMessage.add(messageNew)

        } else throw MessageNotFoundException("Message under id #${messageOld.id} don't exits")
    }

    fun getUnreadChatsCount(): Int { return directMessage.count { message -> !message.isRead } }

    fun getChats() {
        if (directMessage.isNotEmpty())
            directMessage.forEach {
                println("Chat with User under id#${it.idUser} \n $it")
                println("______________________________________________________________")
            }
    }

    fun getMessage(userId: Int) {
        val quantity = directMessage.count { message -> message.idUser == userId }
        println("Chat with User under id#${userId} with messages: \n $quantity")
    }

    fun getMessagesWithId(userId: Int, fromId: Int, messageId: Int) {
        if (isContains(userId, fromId)) {
            return directMessage.filter { message -> message.id == messageId }
                .forEach {  println("Chat with User under id#${userId} with messages: $it") }
        } else throw MessageNotFoundException("Message with id#${messageId} don't exist")

    }

    fun deleteChat(userId: Int, fromId: Int): Boolean {
        directMessage.forEach {
            if (isContains(userId, fromId)) {
                directMessage.remove(it)
                return true
            }
        }
        throw UserNotFoundException("User with id#${userId} doesn't exist")
    }

    fun deleteMessage(userId: Int, fromId: Int, messageId: Int): Boolean {
        directMessage.forEach {
            if (it.idUser == userId && it.fromId == fromId) {
                if (it.id == messageId) {
                    directMessage.remove(it)
                    return true
                } else throw MessageNotFoundException("Message with id#${messageId} don't exist")
            }
        }
        throw UserNotFoundException("User with id#${userId} doesn't exist")
    }
}

