package com.cine.yaolibrary

import android.view.View

/**
 *  @author zhangyao
 *  @date 2022/1/12  14:46
 *  @E-mail android_n@163.com
 */

fun View.setTags(tag: String?) {
    tag?.let {
        setTag(it)
    }
}
