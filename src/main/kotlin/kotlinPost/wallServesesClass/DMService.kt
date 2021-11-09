package kotlinPost.wallServesesClass

import User
import kotlinPost.dataClass.dt_directmasseges.Message
import kotlinPost.excaption.MessageNotFoundException
import kotlinPost.excaption.UserNotFoundException


object DMService : WallServices<Message>() {

    private var directMessagesMap = mutableMapOf<Int, MutableList<Message>>()

    private fun isContains(id: Int): Boolean {
        return when (directMessagesMap.containsKey(id)) {
            true -> true
            else -> false
        }
    }

    fun addUsers(user: User): User {
        if (!isContains(user.idUser)) {
            directMessagesMap[user.idUser] = mutableListOf()
        }
        return user
    }

    fun addMessage(message: Message, user: User) {

        when (isContains(user.idUser)) {
            true -> directMessagesMap[user.idUser]?.add(message)
            else -> throw UserNotFoundException("User under id #${user.idUser} is already exist")
        }
    }

    fun updateMessage(user: User, messageOld: Message, messageNew: Message): Message {
        directMessagesMap.forEach {
            when (isContains(user.idUser)) {
                true -> directMessagesMap.replace(user.idUser, mutableListOf(messageOld), mutableListOf(messageNew))
                else -> throw MessageNotFoundException("Message under id #${messageOld.id} don't exits")
            }
        }
        return messageNew
    }

    fun getUnreadChatsCount(user: User): Int {
        directMessagesMap.forEach { _ ->
            if (isContains(user.idUser)) {
                val messagesFromChats = directMessagesMap.getValue(user.idUser)
                return messagesFromChats.count { message -> return@count !message.isRead }
            }
        }
        throw UserNotFoundException("User with id#${user.idUser} doesn't exist")
    }

    fun getChats() {
        directMessagesMap.forEach { (key, value) ->
            if (value.isNotEmpty())
                println("Chat with User under id#$key: \n $value") else
                println("Chat with User under id#$key: \n hasn't got any messages.")
        }
    }

    fun getMessage(user: User): String {
        return when (isContains(user.idUser)) {
            directMessagesMap.getValue(user.idUser).isEmpty() -> "Chat with User under id#${user.idUser} is empty"
            else -> "Chat with User under id#${user.idUser} with messages: \n ${directMessagesMap.getValue(user.idUser)}"

        }
    }

    fun getMessagesWithId(user: User, messageId: Int, countOfMessages: Int) {
        if (isContains(user.idUser)) {
            val mes =
                directMessagesMap.getValue(user.idUser).filter { mess -> mess.id > messageId }.take(countOfMessages)
            when (mes.isEmpty()) {
                true -> println("Chat with User under id#${user.idUser} is empty")
                else -> println("Chat with User under id#${user.idUser} with messages: $mes")
            }
        } else throw MessageNotFoundException("Message with id#${messageId} don't exist")
    }

    fun deleteChat(user: User): Boolean {
        directMessagesMap.forEach {
            if (isContains(user.idUser)) {
                directMessagesMap.remove(user.idUser)
                return true
            }
        }
        throw UserNotFoundException("User with id#${user.idUser} doesn't exist")
    }

    fun deleteMessage(user: User, messag: Message): Boolean {
        directMessagesMap.forEach { _ ->
            if (isContains(user.idUser)) {
                val messagesFromChats = directMessagesMap.getValue(user.idUser)
                for (message in messagesFromChats) {
                    if (message.id == messag.id && messagesFromChats.isNotEmpty()) {
                        messagesFromChats.remove(messag)
                        return true
                    }
                    if (messagesFromChats.isEmpty()) {
                        deleteChat(user)
                        return true
                    } else throw MessageNotFoundException("Message with id#${messag.id} don't exist")
                }
            }
        }
        throw UserNotFoundException("User with id#${user.idUser} doesn't exist")
    }
}
