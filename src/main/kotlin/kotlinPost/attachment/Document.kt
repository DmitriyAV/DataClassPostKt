package kotlinPost.attachment

data class Document(
    val fileTitle: String,
    val fileContent: String
) {
    override fun toString(): String {
        return "Document under title $fileTitle with content $fileContent"
    }
}