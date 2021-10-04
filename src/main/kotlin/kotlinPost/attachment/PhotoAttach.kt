package kotlinPost.attachment

class PhotoAttach(override val type: String = "Photo") : Attachment {
    val result = Photo("Some Photo Title").toString()
    override fun toString(): String {
        return result
    }
}