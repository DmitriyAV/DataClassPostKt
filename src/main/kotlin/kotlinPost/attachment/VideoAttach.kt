package kotlinPost.attachment

class VideoAttach(override val type: String = "Video") : Attachment {
    val result = Video("Some Video Title", "Some Video Author", 4).toString()
    override fun toString(): String {
        return result
    }
}