package com.example.sharedviewmodelexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _score = MutableLiveData<Int>()

    val score : LiveData<Int> = _score

    init {
        _score.value = 0
    }

    fun increment(){

        _score.value = score.value?.plus(1)
    }

    fun reset(){
        _score.value = 0
    }


}