package kotlinPost.wallServesesClass

import kotlinPost.dataClass.Post

object WallServices {
   // private var postId: Int = (0..1000).random()
    private var posts = emptyArray<Post>()


    fun create(posted: Post): Post {
        posts += posted
        for (post in posts){
            if (posts.isNotEmpty()) posts.last().id ++
        }
        return posts.last()
    }

    fun print(){

        println(posts.last()).toString()
        println()
    }


    fun update(post: Post): Boolean {
        for ((index, postInPosts) in posts.withIndex()){
        if (postInPosts.id == post.id) {
            posts[index] = post.copy(id = postInPosts.id, date = postInPosts.date)
            return true
            }
        }
        return false
    }
}