package ru.netology.objects.attachments.objects.postedphoto

import ru.netology.objects.attachments.Attachments

class PostedPhotoAttachment: Attachments {
    override val type: String = "postedPhoto"
    override val typeCoise: PostedPhoto = PostedPhoto()
}