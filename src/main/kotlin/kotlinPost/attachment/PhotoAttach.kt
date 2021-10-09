package kotlinPost.attachment

data class PhotoAttach(override val type: String = "Photo", val photo: Photo? = null) : Attachment {
    val result = Photo("Some Photo Title").toString()
    override fun toString(): String {
        return result
    }
}