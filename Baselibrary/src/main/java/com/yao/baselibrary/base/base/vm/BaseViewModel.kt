package com.yao.baselibrary.base.base.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yao.baselibrary.base.http.ApiException

/**
 *  @author zhangyao
 *  @date 2021/10/24  11:19
 *  @E-mail android_n@163.com
 *  基础vm
 */
open class BaseViewModel:ViewModel() {


    val errorLiveData = MutableLiveData<ApiException>()
}