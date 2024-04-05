package com.example.lab2.model.entity

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class Dog(
    val id: String = UUID.randomUUID().toString(),
    @SerializedName("name") val name: String,
    @SerializedName("image_link") val imageLink: String,
    @SerializedName("barking") val barking: Int,
    @SerializedName("trainability") val trainability: Int,
    @SerializedName("protectiveness") val protectiveness: Int,
    @SerializedName("playfulness") val playfulness: Int,
    @SerializedName("maxHeight") val maxHeight: Int
)
