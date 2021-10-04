package kotlinPost.attachment

class DocAttach(override val type: String = "Doc") : Attachment {
    val result = Document("Some File Title", "Some File Content").toString()
    override fun toString(): String {
        return result
    }
}