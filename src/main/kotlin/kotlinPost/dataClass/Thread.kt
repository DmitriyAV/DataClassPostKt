package kotlinPost.dataClass

class Thread(
   val canPost: Boolean, // (boolean) – может ли текущий пользователь оставлять комментарии в этой ветке.
   val showReplyButton: Boolean, // (boolean) – нужно ли отображать кнопку «ответить» в ветке.
   val groupsCanPost: Boolean //(boolean) – могут ли сообщества оставлять комментарии в ветке.
) {

   val count: Int = 0 //(integer) — количество комментариев в ветке.
   var items: Array<Int>? = null // (array) — массив объектов комментариев к записи (только для метода wall.getComments).

   override fun toString(): String {
      return "${isThread(canPost)}, ${isThread(showReplyButton)}, ${isThread(groupsCanPost)}, Current quantity of comments in thread ${addCommentThread()}"
   }

   private fun addCommentThread(){
      items = items?.plus(1)
      count + 1
   }

   fun isThread(canPost: Boolean): String {
      return when {
         canPost -> "You can comment in thread"
         else -> "You can't comment in thread"
      }
   }


}