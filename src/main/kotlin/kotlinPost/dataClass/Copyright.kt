package kotlinPost.dataClass

class Copyright(
    private val copyrightId: Int, // (integer);
    private val link: String, //* (string);
    private val name: String, //* (string);
    val type: String, //* (string).
) {
    @Override
    override fun toString(): String {
    return "Copyright - $copyrightId Link - $link Name is - $name Type post: $type"
    }
}