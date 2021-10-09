package kotlinPost.attachment

sealed class Attachments(open val type: String) {
    data class AudioAtt(val audio: String) : Attachments(audio.toString())
    data class VideoAtt(val video: String) : Attachments(video.toString())
    data class DocAtt(val doc: String) : Attachments(doc.toString())
    data class LinkAtt(val link: String) : Attachments(link.toString())
    data class PhotoAtt(val photo: String) : Attachments(photo.toString())

}
