package com.cine.newcine.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cine.newcine.bean.ArticleBean
import com.cine.newcine.bean.ArticleListBean
import com.cine.newcine.common.getArticleDiff
import com.cine.newcine.constants.Constants
import com.cine.newcine.databinding.ItemHomeArticleBinding
import com.cine.newcine.databinding.ItemProjectBinding
import com.cine.newcine.R

/**
 *  @author zhangyao
 *  @date 2021/10/25  16:21
 *  @E-mail android_n@163.com
 */
class ArticleAdapter(private val context: Context) :
    ListAdapter<ArticleListBean, RecyclerView.ViewHolder>(getArticleDiff()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Constants.ITEM_ARTICLE) {
            val binding: ItemHomeArticleBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_home_article,
                parent,
                false
            )
            ArticleViewHolder(binding.root)
        } else {
            val binding: ItemProjectBinding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_project,
                parent,
                false
            )
            ArticlePicViewHolder(binding.root)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        holder.itemView.clickNoRepeat {
//            onItemClickListener?.invoke(position,it)
//        }
//        //收藏
//        holder.itemView.findViewById<View>(R.id.ivCollect)?.clickNoRepeat {
//            onItemChildClickListener?.invoke(position,it)
//        }
        val binding = if (holder is ArticleViewHolder) {
            //获取ViewDataBinding
            DataBindingUtil.getBinding<ItemHomeArticleBinding>(holder.itemView)?.apply {
                dataBean = getItem(position)
            }
        } else {
            DataBindingUtil.getBinding<ItemProjectBinding>(holder.itemView)?.apply {
                dataBean = getItem(position)
            }
        }
        binding?.executePendingBindings()
    }

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].itemType == Constants.ITEM_ARTICLE) {
            //普通类型
            Constants.ITEM_ARTICLE
        } else {
            //带图片类型
            Constants.ITEM_ARTICLE_PIC
        }
    }

    /**
     * 默认viewHolder
     */
    class ArticleViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }

    /**
     * 带图片viewHolder
     */
    class ArticlePicViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }
}