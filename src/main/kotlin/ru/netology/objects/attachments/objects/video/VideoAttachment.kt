package ru.netology.objects.attachments.objects.video

import ru.netology.objects.attachments.Attachments

class VideoAttachment: Attachments {
    override val type: String = "video"
    override val typeCoise: Video = Video()
}