package com.example.rickandmorty.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * {
"id": 361,
"name": "Toxic Rick",
"status": "Dead",
"species": "Humanoid",
"type": "Rick's Toxic Side",
"gender": "Male",
"origin": {
"name": "Alien Spa",
"url": "https://rickandmortyapi.com/api/location/64"
},
"location": {
"name": "Earth",
"url": "https://rickandmortyapi.com/api/location/20"
},
"image": "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
"episode": [
"https://rickandmortyapi.com/api/episode/27"
],
"url": "https://rickandmortyapi.com/api/character/361",
"created": "2018-01-10T18:20:41.703Z"
},
 */
@Parcelize
data class Character(
    val id: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val type: String? = null,
    val gender: String? = null,
    val image: String? = null,
    val episodes: List<String?>? = null,
    val url: String? = null,
    val createdAt: String? = null
) : Parcelable