package com.yao.baselibrary.base

import android.app.Application
import android.content.Context

open class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        baseApplication = this
    }

    companion object{
        private lateinit var  baseApplication:BaseApp
        fun getContext():Context{
            return baseApplication
        }
    }


}