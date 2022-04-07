package ru.netology.objects.geo

import ru.netology.objects.geo.objects.Place

data class Geo(
    val type: String? = null,
    val coordinates: String? = null,
    val place: Place? = null
)