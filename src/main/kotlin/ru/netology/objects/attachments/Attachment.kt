package ru.netology.objects.attachments

import ru.netology.objects.attachments.objects.albumphoto.AlbumPhoto
import ru.netology.objects.attachments.objects.app.App
import ru.netology.objects.attachments.objects.audio.Audio
import ru.netology.objects.attachments.objects.document.Document
import ru.netology.objects.attachments.objects.note.Note
import ru.netology.objects.attachments.objects.photo.Photo
import ru.netology.objects.attachments.objects.postedphoto.PostedPhoto
import ru.netology.objects.attachments.objects.video.Video

sealed class Attachment(val type: String) {
    data class PhotoAttachment(val photo: Photo) : Attachment("photo")
    data class VideoAttachment(val video: Video) : Attachment("video")
    data class AudioAttachment(val audio: Audio) : Attachment("audio")
    data class AlbumPhotoAttachment(val albumPhoto: AlbumPhoto) : Attachment("albumPhoto")
    data class PostedPhotoAttachment(val postedPhoto: PostedPhoto) : Attachment("postedPhoto")
    data class AppAttachment(val app: App) : Attachment("app")
    data class DocumentAttachment(val document: Document) : Attachment("doc")
    data class NoteAttachment(val note: Note) : Attachment("note")
}