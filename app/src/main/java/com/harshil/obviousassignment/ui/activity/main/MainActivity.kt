package com.harshil.obviousassignment.ui.activity.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.harshil.obviousassignment.R
import com.harshil.obviousassignment.databinding.ActivityMainBinding
import com.harshil.obviousassignment.ui.activity.details.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private lateinit var imagesAdapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        setUpImagesRv()
        observeJsonData()

    }

    private fun setUpImagesRv() {
        imagesAdapter = ImagesAdapter { position, action ->
            if (action == "open") {
                startActivity(
                    Intent(this, DetailsActivity::class.java).also {
                        it.putParcelableArrayListExtra(
                            "images",
                            ArrayList(viewModel.getImages ?: mutableListOf())
                        )
                        it.putExtra("position", position)
                    }
                )
            }
        }
        binding.rvImages.adapter = imagesAdapter
    }

    private fun observeJsonData() {
        viewModel.jsonData.observe(this) {
            imagesAdapter.setImagesList(it)
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}
