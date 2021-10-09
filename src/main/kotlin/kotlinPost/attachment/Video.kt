package kotlinPost.attachment

data class Video(
    val videoTitle: String,
    val authorName: String,
    val duration: Int
) {
    override fun toString(): String {
        return "Video file under title $videoTitle by author $authorName duration $duration"
    }
}