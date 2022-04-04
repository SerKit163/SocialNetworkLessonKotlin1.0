package ru.netology.objects.attachments.objects.albumphoto

import ru.netology.objects.attachments.Attachments

class AlbumPhotoAttachment: Attachments {
    override val type: String = "albumPhoto"
    override val typeCoise: AlbumPhoto = AlbumPhoto()
}