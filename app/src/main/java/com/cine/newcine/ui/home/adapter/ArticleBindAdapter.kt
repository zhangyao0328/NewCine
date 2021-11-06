package com.cine.newcine.ui.home.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.cine.newcine.R
import com.cine.newcine.common.loadRadius

/**
 *  @author zhangyao
 *  @date 2021/11/5  11:06
 *  @E-mail android_n@163.com
 */
object ArticleBindAdapter {

    @BindingAdapter("value=[articleCollect]")
    @JvmStatic
    fun imgPlayBlur(imgView : ImageView, collect: Boolean){
        if(collect){
            imgView.setImageResource(R.mipmap.collect)
        }else{
            imgView.setImageResource(R.mipmap.un_collect)
        }
    }

    /**
     * 加载网络圆角图片
     */
    @BindingAdapter(value = ["imgUrlRadius"])
    @JvmStatic
    fun imgUrlRadiusCircle(view: ImageView, url: String) {
        view.loadRadius(view.context.applicationContext, url)
    }
}