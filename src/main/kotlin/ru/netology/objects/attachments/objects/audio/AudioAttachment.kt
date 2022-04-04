package ru.netology.objects.attachments.objects.audio

import ru.netology.objects.attachments.Attachments

class AudioAttachment: Attachments {
    override val type: String = "audio"
    override val typeCoise: Audio = Audio()
}