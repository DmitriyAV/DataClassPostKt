package kotlinPost.attachment

sealed class Attachments(open val type: Any) {

    data class AudioAtt(val audio: Audio) : Attachments(audio.toString())
    data class VideoAtt(val video: Video) : Attachments(video.toString())
    data class DocAtt(val doc: Document) : Attachments(doc.toString())
    data class LinkAtt(val link: Link) : Attachments(link.toString())
    data class PhotoAtt(val photo: Photo) : Attachments(photo.toString())

}
