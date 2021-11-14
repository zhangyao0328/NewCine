package com.cine.newcine.http

import retrofit2.Retrofit

class RetrofitManager {

    companion object {

        /**
         * 用于存储apiService
         */
        val map = mutableMapOf<Class<*>, Any>()

        /**
         * 只初始化一次
         */
        private val retrofit = RetrofitFactory.factory()

        /**
         * 动态指定域名
         */
        fun <T : Any> getApiService(apiClass: Class<T>): T {
            return getService(apiClass)
        }

        /**
         * 获取ApiService单利对象
         */
        fun <T : Any> getService(apiClass: Class<T>): T {
            //重入锁单利 避免多线程安全问题
            return if (map[apiClass] == null) {
                synchronized(RetrofitManager::class.java) {
                    val t = retrofit.create(apiClass)
                    if (map[apiClass] == null) {
                        map[apiClass] == t
                    }
                    t
                }
            } else {
                map[apiClass] as T
            }
        }


    }

}