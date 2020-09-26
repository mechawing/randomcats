package com.project.randomcats.ui.single_cat_picture_details

import androidx.lifecycle.LiveData
import com.project.randomcats.data.api.TheCatPictureDBInterface
import com.project.randomcats.data.repository.CatPictureDetailsNetworkDataSource
import com.project.randomcats.data.repository.NetworkState
import com.project.randomcats.data.vo.CatPictureDetails
import io.reactivex.disposables.CompositeDisposable

class CatPictureDetailsRepository (private val apiService : TheCatPictureDBInterface) {

    lateinit var catPictureDetailsNetworkDataSource: CatPictureDetailsNetworkDataSource

    fun fetchSingleCatPictureDetails (compositeDisposable: CompositeDisposable, catPictureId: String) : LiveData<CatPictureDetails> {

        catPictureDetailsNetworkDataSource = CatPictureDetailsNetworkDataSource(apiService,compositeDisposable)
        catPictureDetailsNetworkDataSource.fetchCatPictureDetails(catPictureId)

        return catPictureDetailsNetworkDataSource.downloadedCatPictureResponse

    }

    fun getCatPictureDetailsNetworkState(): LiveData<NetworkState> {
        return catPictureDetailsNetworkDataSource.networkState
    }



}