package com.harshil.obviousassignment.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harshil.obviousassignment.models.ImagesModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    init {
        getJsonData()
    }

    private var _liveJsonData = MutableLiveData<MutableList<ImagesModelItem>>()
    var jsonData: LiveData<MutableList<ImagesModelItem>> = _liveJsonData

    private fun getJsonData() {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getJsonData()
        }
    }

}