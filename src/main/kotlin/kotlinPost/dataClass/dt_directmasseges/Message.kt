package kotlinPost.dataClass.dt_directmasseges


data class Message(
    val idUser: Int,
    val fromId: Int,
    val id: Int,
    val message: String,
    var isEntered: Boolean = true,
    var isRead: Boolean = false,
    ) {

    private fun setIsReadied(): String {
        return when (isRead) {
            true -> "Old"
            else -> "New"
        }
    }

    private fun setIsEntered(): String {
        return when (isEntered) {
            true -> "Incoming"

            else -> "Sent from you"
        }
    }

    override fun toString(): String {
        return "${setIsReadied()} ${setIsEntered()} Message under id#$id  \n" +
                "from user #$fromId \n" +
                "Text: $message \n"
    }
}