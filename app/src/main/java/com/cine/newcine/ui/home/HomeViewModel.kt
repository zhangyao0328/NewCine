package com.cine.newcine.ui.home

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cine.newcine.MainActivity
import com.cine.newcine.bean.ArticleListBean
import com.yao.baselibrary.base.base.vm.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : BaseViewModel() {

    //测试文本
    val _text = MutableLiveData<String>()
    val username: LiveData<String> = _text


    //web文章页list
    val _articalList = MutableLiveData<ArticleListBean>()
    val articalList : LiveData<ArticleListBean> = _articalList

    fun setText() {
        viewModelScope.launch {
            _text.value = data()
        }
    }

   suspend fun data() = withContext(Dispatchers.Main) {
        val list = listOf("zy", "wwy", "zl", "sbl", "nrck", "sss999sssss")
       list.maxByOrNull { fruit: String -> fruit.length }
    }
}