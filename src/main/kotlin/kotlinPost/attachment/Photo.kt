package kotlinPost.attachment

data class Photo(
    val photoTitle: String
) {
    override fun toString(): String {
        return "Photo under title $photoTitle"
    }
}