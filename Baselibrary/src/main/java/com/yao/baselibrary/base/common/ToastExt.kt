package com.yao.baselibrary.base.common

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.annotation.StringRes
import com.yao.baselibrary.base.BaseApp

/**
 * Toast工具类
 */

fun Context.toast(content: String, duration : Int = Toast.LENGTH_SHORT){
    if(TextUtils.isEmpty(content)){
        return
    }
    Toast.makeText(this, content, duration).apply {
        show()
    }
}

fun Context.toast(@StringRes resId:Int, duration: Int = Toast.LENGTH_SHORT){
    toast(getString(resId, duration))
}

fun toast(content: String, duration: Int = Toast.LENGTH_SHORT){
    if(TextUtils.isEmpty(content)){
        return
    }
    BaseApp.getContext().toast(content, duration)
}