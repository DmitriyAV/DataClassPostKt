data class User(
    val idUser: Int,
) {
    override fun toString(): String {
        return "User under id #$idUser \n"
    }
}