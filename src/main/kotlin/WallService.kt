package attachment

class PostNotFoundException(message: String) : RuntimeException(message)

internal class WallService {

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        val newId = if (posts.isNotEmpty()) posts.last().id + 1 else 1
        posts += post.copy(id = newId)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[index] = post.copy(ownerId = currentPost.ownerId, date = currentPost.date)
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment) {
        for (post in posts) {
            if (post.id == comment.replyToPost) {
                comments += comment
                return
            }
        }
        throw PostNotFoundException("Post not found (id = ${comment.replyToPost})")
    }

}