package ru.netology.objects.geo.objects

data class Place(
    val id: Int = 0,
    val title: String? = null,
    val latitude: Int = 0,
    val longitude: Int = 0,
    val created: Int = 0,
    val icon: String? = null,
    val checkins: Int = 0,
    val update: Int = 0,
    val type: Int = 0,
    val country: Int = 0,
    val city: Int = 0,
    val address: String? = null
)