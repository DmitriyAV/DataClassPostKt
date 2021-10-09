package kotlinPost.attachment

data class DocAttach(override val type: String = "Doc", val document: Document? = null) : Attachment {
    val result = Document("Some File Title", "Some File Content").toString()
    override fun toString(): String {
        return result
    }
}