package ru.netology.objects.attachments.objects.document

import ru.netology.objects.attachments.Attachments

class DocumentAttachment: Attachments {
    override val type: String = "doc"
    override val typeCoise: Document = Document()
}