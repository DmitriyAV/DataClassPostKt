package kotlinPost.dataClass

class Like(
    val canLike: Boolean, //* (integer, [0,1]) — информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);

) {
    private var countLikes: Int = (0..100).random() //(integer) — число пользователей, которым понравилась запись;
    private var userLikes: Boolean = true //* (integer, [0,1]) — наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
    @Override
    override fun toString(): String {
        return "Like's quantity: ${isLike(isAbleToLike(canLike))}"
    }

    private fun isLike(can: Boolean): String {
       val result = when (can) {
            true -> ifCount(userLikes) + " $countLikes"
            false -> ifCount(can)
        }
        return result
    }

    private fun isAbleToLike(can: Boolean): Boolean {
        return can
    }

    private fun ifCount(userLikes: Boolean): String{
        return when (userLikes){
            true -> "Post was liked"
            false -> "Post wasn't liked"
        }
    }

}