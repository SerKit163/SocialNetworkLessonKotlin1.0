package ru.netology.objects.attachments.objects.note

import ru.netology.objects.attachments.Attachments

class NoteAttachment: Attachments {
    override val type: String = "note"
    override val typeCoise: Note = Note()
}