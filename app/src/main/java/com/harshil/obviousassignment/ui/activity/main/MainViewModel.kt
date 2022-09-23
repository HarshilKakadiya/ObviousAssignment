package com.harshil.obviousassignment.ui.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harshil.obviousassignment.models.ImagesModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private var _liveJsonData = MutableLiveData<MutableList<ImagesModelItem>>()
    var jsonData: LiveData<MutableList<ImagesModelItem>> = _liveJsonData

    internal val getImages : MutableList<ImagesModelItem>?
        get() = jsonData.value

    init {
        getJsonData()
    }

    private fun getJsonData() {
        viewModelScope.launch {
            val list = mainRepository.getJsonData() ?: mutableListOf()
            _liveJsonData.value = list
        }
    }

}