package kotlinPost.attachment

data class LinkAttach(override val type: String = "Link", val  link: Link? = null) : Attachment {
    val result = Link("Some Link Path").toString()
    override fun toString(): String {
        return result
    }
}