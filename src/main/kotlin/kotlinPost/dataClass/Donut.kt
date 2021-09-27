package kotlinPost.dataClass

import java.util.*

class Donut(
    private var isDonut: Boolean,
    //(boolean) — запись доступна только платным подписчикам VK Donut;

    private val canPublishFreeCopy: Boolean,
    // (boolean) — можно ли открыть запись для всех пользователей, а не только подписчиков VK Donut;
) {

    private var paidDuration: Int = (1..24).random() //(integer) — время, в течение которого запись будет доступна только платным подписчикам VK Donut;

    private var placeholder: String = "Access denied!" //(object) — заглушка для пользователей, которые не оформили подписку VK Donut. Отображается вместо содержимого записи.

    private lateinit var editMode: String
    //(string) — информация о том, какие значения VK Donut можно изменить в записи. Возможные значения:
    // all — всю информацию о VK Donut.
    // duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut.


    private fun edit(acc: Boolean): String {
        if (acc) return "all"
        else editMode = when {
            isDonut -> "all"
            !isDonut -> "$placeholder $paidDuration"
            else -> " "
        }
        return editMode
    }

    @Override
    override fun toString(): String {
        return "${edit(canPublishFreeCopy)} "
    }
}