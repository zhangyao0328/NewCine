package com.yao.baselibrary.base.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

/**
 *  @author zhangyao
 *  @date 2021/11/5  13:25
 *  @E-mail android_n@163.com
 */
abstract class LazyVmFragment<BD:ViewBinding>(inflater: (LayoutInflater, ViewGroup?, Boolean) -> BD) : BaseFragment<BD>(
    inflater
) {



}