package kotlinPost.attachment

data class Audio(
    val trackTitle: String,
    val artistName: String,
    val duration: Int
) {
    override fun toString(): String {
        return "Audio under title $trackTitle by artist $artistName duration $duration"
    }
}
