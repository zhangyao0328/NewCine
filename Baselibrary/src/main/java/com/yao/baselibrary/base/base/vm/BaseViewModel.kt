package com.yao.baselibrary.base.base.vm

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yao.baselibrary.BuildConfig
import com.yao.baselibrary.base.common.toast
import com.yao.baselibrary.base.http.ApiException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 *  @author zhangyao
 *  @date 2021/10/24  11:19
 *  @E-mail android_n@163.com
 *  基础vm
 */
open class BaseViewModel : ViewModel() {


    val errorLiveData = MutableLiveData<ApiException>()

    protected fun <T> launch(block: suspend () -> T) {
        viewModelScope.launch {
            kotlin.runCatching {
                block()
            }.onFailure {
                if (BuildConfig.DEBUG) {
                    it.printStackTrace()
                    return@onFailure
                }

                getApiException(it).apply { 
                    withContext(Dispatchers.Main){
                        toast(errorMessage)
                        errorLiveData.value = this@apply
                    }
                }
            }
        }
    }

    /**
     * 捕获异常信息
     */
    private fun getApiException(e: Throwable): ApiException {
        return when (e) {
            is UnknownHostException -> {
                ApiException("网络异常", -100)
            }
            is JSONException -> {
                ApiException("数据异常", -100)
            }
            is SocketTimeoutException -> {
                ApiException("连接超时", -100)
            }
            is ConnectException -> {
                ApiException("连接错误", -100)
            }
            is HttpException ->{
                ApiException("http code ${e.code()}", -100)
            }
            /**
             * 如果协程还在运行，个别机型退出当前界面时，viewModel会通过抛出CancellationException，强制结束协程，
             * 与java中的InterruptException类似，所以不必理会，只需将toast隐藏即可
             */
            is CancellationException ->{
                ApiException("", -100)
            }
            else -> {
                ApiException("未知异常", -100)
            }
        }
    }
}