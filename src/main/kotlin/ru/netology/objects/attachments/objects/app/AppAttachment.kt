package ru.netology.objects.attachments.objects.app

import ru.netology.objects.attachments.Attachments

class AppAttachment: Attachments {
    override val type: String = "app"
    override val typeCoise: App = App()
}