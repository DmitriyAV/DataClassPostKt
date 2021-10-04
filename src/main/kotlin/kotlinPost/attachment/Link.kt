package kotlinPost.attachment

class Link(
    val linkPath: String
) {
    override fun toString(): String {
        return "Content from $linkPath"
    }
}