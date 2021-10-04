package kotlinPost.dataClass

class Repost(
    val canPublish: Boolean,
    // * (integer, [0,1]) — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).

) {

    private var countReposted: Int = (0..20).random()   //(integer) — число пользователей, скопировавших запись;
    private var userReposted: Boolean =
        false//* (integer, [0,1]) — наличие репоста от текущего пользователя (1 — есть, 0 — нет).


    @Override
    override fun toString(): String {
        return "Quantity of repost is: ${isReposted(isAbleReposted(ifChange()))?:isAbleReposted(false)}"
    }

    private fun isAbleReposted(can: Boolean): String {
        return if (can) "Able to repost" else "Don't able to repost"
    }

    private fun isReposted(can: String): Int? {
        if (can === "Able to repost") countReposted
        return null
    }

    private fun ifChange(): Boolean {
        if (canPublish) userReposted = true
        return userReposted
    }
}