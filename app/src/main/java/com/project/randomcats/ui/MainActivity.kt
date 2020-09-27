package com.project.randomcats.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.randomcats.R
import com.project.randomcats.ui.single_cat_picture_details.SingleCatPicture
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            val intent = Intent(this, SingleCatPicture::class.java)
            this.startActivity(intent)
        }

    }
}