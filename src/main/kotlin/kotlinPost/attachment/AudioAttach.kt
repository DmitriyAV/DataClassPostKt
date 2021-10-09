package kotlinPost.attachment

data class AudioAttach(override val type: String = "Audio", val audio: Audio? = null) : Attachment {

    val result = Audio("Some Track", "Some Artist", 5).toString()

    override fun toString(): String {
        return result
    }

}