package com.cine.newcine.ui.home

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val _text = MutableLiveData<String>().apply {
        value = data()
    }
    val text: LiveData<String> = _text

    /**
     * 用户名
     */
    val username = ObservableField<String>().apply {
        _text.value
        set("请先登录")
    }

    fun data(): String {
        val list = listOf("zy", "wwy", "zl", "sbl", "nrck")
        var temp = ""
        for (item in list) {
            if (item.length > temp.length) {
                temp = item
            }
        }
        return temp
    }
}