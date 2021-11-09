package com.cine.newcine.common

import android.content.res.Resources
import android.util.TypedValue
import com.bumptech.glide.load.engine.Resource
import com.scwang.smart.refresh.layout.SmartRefreshLayout

/**
 *  @author zhangyao
 *  @date 2021/11/6  22:10
 *  @E-mail android_n@163.com
 */

/**
 * 隐藏刷新新加载ui
 */
fun SmartRefreshLayout.smartDismiss() {
    finishRefresh(0)
    finishLoadMore(0)
}

/**
 * 配置SmartRefreshLayout
 */
fun SmartRefreshLayout.smartConfig() {
    //加载
    setEnableLoadMore(true)
    //刷新
    setEnableRefresh(true)
    //不满一页关闭加载
    //setEnableLoadMoreWhenContentNotFull(false)
    //滚动回弹
    setEnableOverScrollDrag(true)
}


val Float.px: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )