package ru.netology.objects.comments

data class ReportComment(
    val ownerId: Int = 0,
    val commentId: Int = 0,
    val reason: Array<String> = reasons
)

val reasons = arrayOf(
    "Спам",
    "Детская порнография",
    "Экстремизм",
    "Насилие",
    "Пропаганда наркотиков",
    "Материал для взрослых",
    "Оскорбление",
    "Призывы к суициду"
)

