package com.cine.newcine.ui.home

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cine.newcine.MainActivity
import com.cine.newcine.bean.ArticleListBean
import com.cine.newcine.constants.Constants
import com.yao.baselibrary.base.base.vm.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : BaseViewModel() {

    //测试文本
    val _text = MutableLiveData<String>()
    val username: LiveData<String> = _text


    //web文章页list
    val _articalList = MutableLiveData<MutableList<ArticleListBean>>()
    val articalList: LiveData<MutableList<ArticleListBean>> = _articalList

    fun setText() {
        viewModelScope.launch {

            val list = mutableListOf<ArticleListBean>()
            for (i in 1..12){
               var bean =  ArticleListBean()
                bean.title = "title$i"
                list.add(bean)
                System.out.println(bean.toString())
            }
            Thread.sleep(2000)
            _articalList.value =list
        }
    }
}