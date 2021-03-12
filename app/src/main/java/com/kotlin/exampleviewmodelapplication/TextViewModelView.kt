package com.kotlin.exampleviewmodelapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModelView  : ViewModel() {

    var number = 0

    val currentNubmer : MutableLiveData<Int> by lazy{
        MutableLiveData<Int>()
    }

    val currentBoolean : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
}