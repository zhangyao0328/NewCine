package com.cine.newcine.ui.home

import com.cine.newcine.bean.ArticleListBean
import com.cine.newcine.http.ApiService
import com.cine.newcine.http.RetrofitManager
import com.yao.baselibrary.base.base.repo.BaseRepository
import retrofit2.Retrofit

class HomeRepo : BaseRepository() {

    private var page = 8

    suspend fun getArticles() = withIO{
        page = 0
        RetrofitManager.getApiService(ApiService::class.java)
            .getTopList()
            .data()
            .let {
                ArticleListBean.trans(it)
            }?: mutableListOf()
    }


}