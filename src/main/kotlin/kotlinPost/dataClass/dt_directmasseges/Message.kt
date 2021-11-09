package kotlinPost.dataClass.dt_directmasseges

import User
import kotlinPost.dataClass.Element

data class Message(
    override val fromId: Int,
    override val date: Int,
    override val id: Int,
    val message: String,
    var isEntered: Boolean = true,
    var isRead: Boolean = false


    ) : Element(id, date, fromId) {

    private fun setIsReadied(): String {
        return when(isRead){
            true -> "Old"
            else -> "New"
        }
    }

    private fun setIsEntered(): String {
        return when(isEntered) {
            true -> "Incoming"

            else -> "Sent from you"
        }
    }

    override fun toString(): String {
        return " ${setIsReadied()} ${setIsEntered()} Message to #${User(id)}, \n" +
                "from user #$fromId \n" +
                "Text: $message \n" +
                "Date: $date"
    }
}