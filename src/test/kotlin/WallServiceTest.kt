package attachment

import org.junit.Test
import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add_Basic() {

        // arrange
        val wallService = WallService()
        val firstPost = Post(text = "First post")
        val secondPost = Post(
            text = "Second post",
            attachments = arrayOf(
                VideoAttachment(video = Video()),
                PhotoAttachment(photo = Photo()),
                AudioAttachment(audio = Audio()),
                DocAttachment(doc = Doc()),
                LinkAttachment(link = Link())
            )
        )

        // act
        val addedFirstPost = wallService.add(firstPost)
        val addedSecondPost = wallService.add(secondPost)
        val result = addedFirstPost.id

        // assert
        assertNotEquals(0, result)

    }

    @Test
    fun update_ExistingId() {

        // arrange
        val wallService = WallService()
        val newPost = Post(text = "First post")
        val post = wallService.add(newPost)
        val postId = post.id

        // act
        val updatedPost = Post(id = postId, text = "Updated post")
        val result = wallService.update(updatedPost)

        // assert
        assertTrue(result)

    }

    @Test
    fun update_NotExistingId() {

        // arrange
        val wallService = WallService()
        val newPost = Post(text = "First post")
        val post = wallService.add(newPost)
        val postId = post.id + 1

        // act
        val updatedPost = Post(id = postId, text = "Updated post")
        val result = wallService.update(updatedPost)

        // assert
        assertFalse(result)

    }

    @Test
    fun createComment_ExistingId() {

        // arrange
        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))

        val postId = post.id

        // act
        wallService.createComment(Comment(replyToPost = postId, text = "First comment"))

        // assert
        assertTrue(true)

    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_NotExistingId() {

        // arrange
        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))

        val postId = post.id + 1

        // act
        wallService.createComment(Comment(replyToPost = postId, text = "First comment"))

        // assert
        assertTrue(false)

    }

    @Test
    fun createReport_ExistingCommentId() {

        // arrange
        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))
        val postId = post.id

        val comment = wallService.createComment(Comment(replyToPost = postId, text = "First comment"))
        val commentId = comment.id

        // act
        wallService.reportComment(commentId = commentId, reason = 0U)

        // assert
        assertTrue(true)

    }

    @Test(expected = CommentNotFoundException::class)
    fun createReport_NotExistingCommentId() {

        // arrange
        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))
        val postId = post.id

        val comment = wallService.createComment(Comment(replyToPost = postId, text = "First comment"))
        val commentId = comment.id + 1

        // act
        wallService.reportComment(commentId = commentId, reason = 0U)

        // assert
        assertTrue(true)

    }

    @Test(expected = IncorrectReasonException::class)
    fun createReport_IncorrectReason() {

        // arrange
        val wallService = WallService()
        val post = wallService.add(Post(text = "First post"))
        val postId = post.id

        val comment = wallService.createComment(Comment(replyToPost = postId, text = "First comment"))
        val commentId = comment.id

        // act
        wallService.reportComment(commentId = commentId, reason = 9U)

        // assert
        assertTrue(true)

    }

}