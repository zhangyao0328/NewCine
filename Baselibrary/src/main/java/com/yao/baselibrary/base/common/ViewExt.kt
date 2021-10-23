package com.yao.baselibrary.base.common

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager

/**
 *  @author zhangyao
 *  @date 2021/10/21  17:26
 *  @E-mail android_n@163.com
 *  view的扩展方法
 */


/**
 * ViewPager于fragment绑定
 * 通过BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT支持懒加载
 */
fun ViewPager.initFragment(
    manger: FragmentManager,
    fragmentList: MutableList<Fragment>
): ViewPager {
    adapter = object : FragmentStatePagerAdapter(manger, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getCount() = fragmentList.size

        override fun getItem(position: Int) = fragmentList[position]

        override fun saveState(): Parcelable? = null
    }
    return this
}

/**
 * ViewPage被选中
 */
fun ViewPager.doSelect(select:(Int) -> Unit){
    addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            select.invoke(position)
        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    })
}
