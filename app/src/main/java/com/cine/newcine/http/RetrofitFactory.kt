package com.cine.newcine.http

import android.provider.SyncStateContract
import com.cine.newcine.constants.ApiConstants
import com.cine.newcine.constants.Constants
import com.franmontiel.persistentcookiejar.ClearableCookieJar
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import com.yao.baselibrary.base.http.HttpLoggingInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import com.yao.baselibrary.base.BaseApp.Companion.getContext
import okhttp3.Cache
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

object RetrofitFactory {

    //缓存100MB
    private val onHttpClientBuilder: OkHttpClient.Builder
        //缓存100Mb
        get() {
            return OkHttpClient.Builder()
                .readTimeout(
                    Constants.DEFAULT_TIMEOUT.toLong(),
                    TimeUnit.MILLISECONDS
                )
                .connectTimeout(
                    Constants.DEFAULT_TIMEOUT.toLong(),
                    TimeUnit.MILLISECONDS
                )
                .addInterceptor(getLogInterceptor())
                .cookieJar(getCookie())
                //添加读取本地缓存拦截器
//                .addNetworkInterceptor(getCacheData())
                .cache(getCache())
        }


    fun factory(): Retrofit {
        return Retrofit.Builder()
            .client(onHttpClientBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ApiConstants.BASH_URL)
            .build()
    }


    /**
     * 获取日志拦截器
     */
    private fun getLogInterceptor(): Interceptor {
        return HttpLoggingInterceptor("okhttp").apply {
            setPrintLevel(HttpLoggingInterceptor.Level.BODY)
            setColorLevel(Level.FINE)
        }
    }

    /**
     * 获取cookie持久化
     */
    private fun getCookie(): ClearableCookieJar {
        return PersistentCookieJar(
            SetCookieCache(),
            SharedPrefsCookiePersistor(getContext())
        )
    }

    /**
     * 获取缓存
     * 100M
     */
    private fun getCache(): Cache {
        return Cache(
            File(getContext().cacheDir, "cache"),
            1024 * 1024 * 100
        )
    }

    /**
     * 本地缓存读取
     * 此方法无需服务端任何操作，适用于服务器端没有其他缓存策略，
     * 如果服务器端有增加的缓存策略，以下不适用
     */
    private fun getCacheData(): Interceptor {
        //缓存时间60s
        val maxAge = 60
        return Interceptor { chain ->
            chain.proceed(chain.request())
                .newBuilder()
                //清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                .removeHeader("Pragma")
                .header("Cache-Control", "public ,max-age=" + maxAge)
                .build()
        }
    }


}