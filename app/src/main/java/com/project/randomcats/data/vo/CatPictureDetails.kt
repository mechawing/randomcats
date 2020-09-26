package com.project.randomcats.data.vo


import com.google.gson.annotations.SerializedName

data class CatPictureDetails(
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)