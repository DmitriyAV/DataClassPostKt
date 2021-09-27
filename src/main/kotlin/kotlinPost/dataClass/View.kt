package kotlinPost.dataClass

class View(
    private var countView: Int,
    //(integer) — число просмотров записи.
) {
    @Override
    override fun toString(): String {
        return "View's of this post: ${countView++}"
    }
}