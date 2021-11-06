package com.cine.newcine.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.cine.newcine.R

/**
 *  @author zhangyao
 *  @date 2021/11/5  11:14
 *  @E-mail android_n@163.com
 */
fun ImageView.loadRadius(context: Context, url: String, radius: Int = 20){
    Glide.with(context)
        .load(url)
        .centerCrop()
        .error(R.mipmap.ic_launcher)
        .into(this
        )
}