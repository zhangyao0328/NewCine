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

    private val homeRepo by lazy { HomeRepo() }

    //测试文本
    val _text = MutableLiveData<String>()
    val username: LiveData<String> = _text


    //web文章页list
    val _articalList = MutableLiveData<MutableList<ArticleListBean>>()
    val articalList: LiveData<MutableList<ArticleListBean>> = _articalList

    fun getArticle() {
        launch {
            val list = mutableListOf<ArticleListBean>()
            val articles = viewModelScope.async {
                homeRepo.getArticles()
            }
            list.addAll(articles.await())
            _articalList.value = list
        }
    }
}