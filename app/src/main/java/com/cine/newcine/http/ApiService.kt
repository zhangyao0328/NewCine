package com.cine.newcine.http

import com.cine.newcine.bean.ArticleBean
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    /**
     * 获取首页置顶文章数据
     */
    @GET("/article/top/json")
    suspend fun getTopList() : ApiResponse<MutableList<ArticleBean.DatasBean>>
}