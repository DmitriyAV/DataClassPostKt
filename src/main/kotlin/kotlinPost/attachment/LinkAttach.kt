package kotlinPost.attachment

class LinkAttach(override val type: String = "Link") : Attachment {
    val result = Link("Some Link Path").toString()
    override fun toString(): String {
        return result
    }
}