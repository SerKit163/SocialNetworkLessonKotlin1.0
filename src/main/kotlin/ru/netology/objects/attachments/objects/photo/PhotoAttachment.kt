package ru.netology.objects.attachments.objects.photo

import ru.netology.objects.attachments.Attachments

class PhotoAttachment: Attachments {
    override val type: String = "photo"
    override val typeCoise: Photo = Photo()
}