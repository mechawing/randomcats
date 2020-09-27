package com.project.randomcats.ui.single_cat_picture_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.project.randomcats.R
import com.project.randomcats.data.api.TheCatPictureDBClient
import com.project.randomcats.data.api.TheCatPictureDBInterface
import com.project.randomcats.data.repository.NetworkState
import com.project.randomcats.data.vo.CatPictureDetails
import kotlinx.android.synthetic.main.activity_single_cat_picture.*

class SingleCatPicture : AppCompatActivity() {

    private lateinit var viewModel: SingleCatPictureViewModel
    private lateinit var catPictureRepository: CatPictureDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_cat_picture)


        val apiService : TheCatPictureDBInterface = TheCatPictureDBClient.getClient()
        catPictureRepository = CatPictureDetailsRepository(apiService)

        viewModel = getViewModel()

        viewModel.catPictureDetails.observe(this, Observer {
            bindUI(it)
        })

        viewModel.networkState.observe(this, Observer {
            progress_bar.visibility = if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
            txt_error.visibility = if (it == NetworkState.ERROR) View.VISIBLE else View.GONE

        })

    }

    fun bindUI( it: CatPictureDetails){
        val CatPicturePosterURL = it.file
        Glide.with(this)
            .load(CatPicturePosterURL)
            .into(iv_cat_image);
    }


    private fun getViewModel(): SingleCatPictureViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SingleCatPictureViewModel(catPictureRepository) as T
            }
        })[SingleCatPictureViewModel::class.java]
    }
}