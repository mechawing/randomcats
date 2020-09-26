package com.project.randomcats.ui.single_cat_picture_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.randomcats.data.repository.NetworkState
import com.project.randomcats.data.vo.CatPictureDetails
import io.reactivex.disposables.CompositeDisposable

class SingleCatPictureViewModel(private val catPictureRepository: CatPictureDetailsRepository, catPictureId: String)  : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val catPictureDetails : LiveData<CatPictureDetails> by lazy {
        catPictureRepository.fetchSingleCatPictureDetails(compositeDisposable,catPictureId)
    }

    val networkState : LiveData<NetworkState> by lazy {
        catPictureRepository.getCatPictureDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}