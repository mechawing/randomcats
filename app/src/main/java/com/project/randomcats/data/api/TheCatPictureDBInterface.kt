package com.project.randomcats.data.api

import com.project.randomcats.data.vo.CatPictureDetails
import io.reactivex.Single
import retrofit2.http.GET

interface TheCatPictureDBInterface {


    @GET("meow")
    fun getCatPictureDetails() : Single<CatPictureDetails>

}