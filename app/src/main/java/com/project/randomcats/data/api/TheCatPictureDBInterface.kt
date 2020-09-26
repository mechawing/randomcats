package com.project.randomcats.data.api

import com.project.randomcats.data.vo.CatPictureDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TheCatPictureDBInterface {

    // https://api.thecatapi.com/v1/images/a9u?api_key=3c459685-3ea6-4918-ba4a-d9f10e0a7864
    // https://api.thecatapi.com/v1


    @GET("images/{image_id}")
    fun getCatPictureDetails(@Path("image_id") id: String): Single<CatPictureDetails>
}