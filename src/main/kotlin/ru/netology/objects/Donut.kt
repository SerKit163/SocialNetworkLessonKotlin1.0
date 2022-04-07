package ru.netology.objects

import java.util.Objects

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeholder: Objects,
    val canPublishFreeCopy: Boolean,
    val editMode: String
)