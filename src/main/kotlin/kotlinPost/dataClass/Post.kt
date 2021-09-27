package kotlinPost.dataClass

data class Post(
    var id: Int = 0, //идентификатор записи
    val ownerId: Int, //идентификатор владельца стены, на которой размещена запись.
    val fromId: Int, //идентификатор автора записи (от чьего имени опубликована запись).
    val createdBy: Int,  //идентификатор администратора, который опубликовал запись.
    val date: Int, //время публикации записи в формате unixtime.
    val text: String,//текст записи.
    val replyOwnerId: Int, //идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyPostId: Int, //идентификатор записи, в ответ на которую была оставлена текущая.
    val friendsOnly: Boolean, //true, если запись была создана с опцией «Только для друзей».
    val comments: Comments,  //информация о комментариях к записи, объект с полями:
    val copyright: Copyright,  //object источник материала, объект с полями:
    val likes: Like, // object	информация о лайках к записи, объект с полями:
    val reposts: Repost,  //object	информация о репостах записи («Рассказать друзьям»), объект с полями:
    val views: View,  //object	информация о просмотрах записи. Объект с единственным полем:
    val postType: String,  //string	тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signerId: Int,  //integer	идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    val canPin: Boolean, //integer, [0,1]	информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
    val canDelete: Boolean, // integer, [0,1]	информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
    val canEdit: Boolean, //integer, [0,1]	информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
    val isPinned: Boolean, //integer, [1]	информация о том, что запись закреплена.
    val markedAsAds: Boolean, // integer, [0,1]	информация о том, содержит ли запись отметку "реклама" (1 — да, 0 — нет).
    val isFavorite: Boolean, // boolean	true, если объект добавлен в закладки у текущего пользователя.
    val donut: Donut, // object	информация о записи VK Donut:
    val postponedId: Int, // Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
) {

    @Override
    override fun toString(): String {
        return "Запись $id на стене $ownerId от автора $fromId создана ${postAdminId(date)} ч. назад \n" +
                "Дата $date: \n" +
                "$text,  \n" +
                "${comments.toString()}, \n" +
                "${copyright.toString()}, \n" +
                "${likes.toString()},  ${reposts.toString()},  ${views.toString()} \n" +
                "$postType, Signer: $signerId \n" +
                "${checkPin(canPin)}, ${checkEdit(canEdit)},  ${checkDelete(canDelete)} ${checkIsPined(isPinned)}\n" +
                "${commercial(markedAsAds)}, ${isFav(isFavorite)} \n" +
                "Donut's: ${donut.toString()}, \n" +
                "Postponed: $postponedId " +
                "\n"
    }


    private fun postAdminId(date: Int): Int {
        return when (date) {
            in 0..24 -> createdBy
            else -> 0
        }
    }

    private fun checkIsPined(isPinned: Boolean): String {
        return if (isPinned) "Pined on page" else "Un Pined"
    }


    private fun checkPin(canPin: Boolean): String {
        return when {
            canPin -> "You can pin"
            else -> "You haven't access to pin"
        }
    }
    private fun checkEdit(canEdit: Boolean): String {
        return when {
            canEdit -> " You can edited"
            else -> "You haven't access to edit"
        }
    }
    private fun checkDelete(canDelete: Boolean): String {
        return when {
            canDelete -> "You can delete"
            else -> "You haven't access delete"
        }
    }

    private fun commercial(markedAsAds: Boolean): String {
        return if (markedAsAds) "Commercial post" else "Un commercial post"
    }

    private fun isFav(isFavorite: Boolean): String{
        return if (isFavorite) "Post add in favorites" else "Post doesn't add in favorites"
    }
}