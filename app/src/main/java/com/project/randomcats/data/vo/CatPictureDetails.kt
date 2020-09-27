package com.project.randomcats.data.vo

import com.google.gson.annotations.SerializedName

data class CatPictureDetails(
    @SerializedName("file")
    val `file`: String
)