package com.project.randomcats.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.randomcats.data.api.TheCatPictureDBInterface
import com.project.randomcats.data.vo.CatPictureDetails
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CatPictureDetailsNetworkDataSource (private val apiService : TheCatPictureDBInterface, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    private val _downloadedCatPictureDetailsResponse =  MutableLiveData<CatPictureDetails>()
    val downloadedCatPictureResponse: LiveData<CatPictureDetails>
        get() = _downloadedCatPictureDetailsResponse

    @SuppressLint("LongLogTag")
    fun fetchCatPictureDetails() {

        _networkState.postValue(NetworkState.LOADING)


        try {
            compositeDisposable.add(
                apiService.getCatPictureDetails()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _downloadedCatPictureDetailsResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Log.e("CatPictureDetailsDataSource", it.message.toString())
                        }
                    )
            )

        }

        catch (e: Exception){
            Log.e("CatPictureDetailsDataSource",e.message.toString())
        }


    }
}