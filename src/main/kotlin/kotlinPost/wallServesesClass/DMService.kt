package kotlinPost.wallServesesClass

import kotlinPost.dataClass.dt_directmasseges.Message
import kotlinPost.excaption.MessageNotFoundException
import kotlinPost.excaption.UserNotFoundException


object DMService {

    //private var directMessagesMap = mutableMapOf<Int, MutableList<Message>>()
    var directMessage = mutableListOf<Message>()


    private fun isContains(userId: Int, fromId: Int): Boolean {
        if (directMessage.isNotEmpty()) {
            for (message in directMessage) {
                return when (message.idUser == userId && message.fromId == fromId) {
                    true -> true
                    else -> false
                }
            }
        }
        return true
    }

/*    fun addUsers(user: User): User {
        if (!isContains(user.idUser)) {
            directMessage[user.idUser] = mutableListOf()
        }
        return user
    }*/

    fun addMessage(message: Message) {
        // when (isContains(message.idUser, message.fromId)) {
        /*true ->*/ directMessage += message

        // else -> throw UserNotFoundException("User under id #${message.idUser} is already exist")
        //   }
    }

    fun updateMessage(messageOld: Message, messageNew: Message) {
        if (isContains(messageOld.idUser, messageOld.fromId)) {
            directMessage.remove(messageOld)
            addMessage(messageNew)
        } else throw MessageNotFoundException("Message under id #${messageOld.id} don't exits")
    }

    fun getUnreadChatsCount(): Int {
        return directMessage.count { message -> !message.isRead }
    }

    fun getChats() {
        directMessage.forEach {
            if (directMessage.isNotEmpty())
                println("Chat with User under id#${it.idUser} \n $it")
            println("______________________________________________________________")
        }
    }


    fun getMessage(userId: Int) {
        val quantity = directMessage.count { message -> message.idUser == userId }
        println("Chat with User under id#${userId} with messages: \n $quantity")
    }


    fun getMessagesWithId(userId: Int, fromId: Int, messageId: Int): List<Message> {
        if (isContains(userId, fromId)) {
            return directMessage.filter { message -> message.id == messageId }
        } else throw MessageNotFoundException("Message with id#${messageId} don't exist")

    }

    fun printGetMessages(quantity: List<Message>, userId: Int) {
        println("Chat with User under id#${userId} with messages: $quantity")
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
        for (it in directMessage) {
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

