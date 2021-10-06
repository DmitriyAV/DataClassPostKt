package kotlinPost.attachment

data class VideoAttach(override val type: String = "Video", val video: Video? = null) : Attachment {
    val result = Video("Some Video Title", "Some Video Author", 4).toString()
    override fun toString(): String {
        return result
    }
}