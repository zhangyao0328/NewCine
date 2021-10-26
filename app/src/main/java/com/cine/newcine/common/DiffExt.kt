package com.cine.newcine.common

import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.DiffUtil
import com.cine.newcine.bean.ArticleListBean
import java.util.*

/**
 *  @author zhangyao
 *  @date 2021/10/25  16:41
 *  @E-mail android_n@163.com
 */
fun getArticleDiff(): DiffUtil.ItemCallback<ArticleListBean>{

    return object : DiffUtil.ItemCallback<ArticleListBean>() {
        override fun areItemsTheSame(oldItem: ArticleListBean, newItem: ArticleListBean): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ArticleListBean,
            newItem: ArticleListBean
        ): Boolean {
            //只有点赞和时间可能存在改变
            return oldItem.collect == newItem.collect
                    && oldItem.date == newItem.date
        }
    }
}