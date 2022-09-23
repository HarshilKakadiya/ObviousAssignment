package com.harshil.obviousassignment.ui.activity.details

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.harshil.obviousassignment.R
import com.harshil.obviousassignment.databinding.ActivityDetailsBinding
import com.harshil.obviousassignment.models.ImagesModelItem
import com.harshil.obviousassignment.utils.Utils.parcelableArrayList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private var imagesList: MutableList<ImagesModelItem>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        binding.lifecycleOwner = this

        setUpToolbar()

        try {
            imagesList = intent.parcelableArrayList("images")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        setUpVp()

    }

    private fun setUpToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun setUpVp() {
        binding.vpImages.adapter = ImageDetailsAdapter(imagesList ?: mutableListOf())
        binding.vpImages.post {
            binding.vpImages.currentItem = intent.getIntExtra("position", 0)
            binding.vpImages.setCurrentItem(intent.getIntExtra("position", 0), false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> false
        }
    }

    companion object {
        private const val TAG = "DetailsActivity"
    }

}