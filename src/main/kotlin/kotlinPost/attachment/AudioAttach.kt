package kotlinPost.attachment

class AudioAttach(override val type: String = "Audio") : Attachment {

    val result = Audio("Some Track", "Some Artist", 5).toString()

    override fun toString(): String {
        return result
    }

}