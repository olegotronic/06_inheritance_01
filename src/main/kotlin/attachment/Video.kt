package attachment

data class Video(
    val id: Int = 0,
    val ownerId: Int = 0,
    val title: String = "",
    val description: String = "",
    val duration: Int = 0,
    val image: Array<String>? = null,
    val firstFrame: Array<String>? = null,
    val date: Int = 0,
    val addingDate: Int = 0,
    val views: Int = 0,
    val localViews: Int? = null,
    val comments: Int = 0,
    val player: String = "",
    val platform: String? = null,
    val canAdd: Boolean = false,
    val isPrivate: Boolean? = null,
    val accessKey: String? = null,
    val processing: Boolean? = null,
    val isFavorite: Boolean = false,
    val canComment: Boolean = false,
    val canEdit: Boolean = false,
    val canLike: Boolean = false,
    val canRepost: Boolean = false,
    val canSubscribe: Boolean = false,
    val canAddToFaves: Boolean = false,
    val canAttachLink: Boolean = false,
    val width: Int = 0,
    val height: Int = 0,
    val userId: Int = 0,
    val converting: Boolean = false,
    val added: Boolean = false,
    val isSubscribed: Boolean = false,
    val repeat: Int = 0,
    val balance: Int = 0,
    val liveStatus: String = "",
    val live: Boolean? = null,
    val upcoming: Boolean? = null,
    val spectators: Int = 0,
    val likes: Int = 0,
    val reposts: Int = 0,
)