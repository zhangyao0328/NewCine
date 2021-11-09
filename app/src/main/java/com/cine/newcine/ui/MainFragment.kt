package com.cine.newcine.ui

import android.app.Notification
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.cine.newcine.databinding.FragmentMainBinding
import com.cine.newcine.ui.dashboard.DashboardFragment
import com.cine.newcine.ui.home.HomeFragment
import com.cine.newcine.ui.notifications.NotificationsFragment
import com.google.android.material.navigation.NavigationView
import com.yao.baselibrary.base.base.BaseFragment
import com.yao.baselibrary.base.common.doSelect
import com.yao.baselibrary.base.common.initFragment
import com.cine.newcine.R

/**
 *  @author zhangyao
 *  @date 2021/10/21  16:32
 *  @E-mail android_n@163.com
 */
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    var listFragment = arrayListOf<Fragment>()

    //首页
    val homeFragment by lazy { HomeFragment() }

    //发现
    val dashboardFragment by lazy { DashboardFragment() }

    //消息
    val notificationsFragment by lazy { NotificationsFragment() }

    init {
        listFragment.apply {
            add(homeFragment)
            add(dashboardFragment)
            add(notificationsFragment)
        }
    }


    override fun init(savedInstanceState: Bundle?) {

        binding.vpHome.initFragment(childFragmentManager, listFragment).run {
            //设置偏移量，全部缓存，避免重复加载
            offscreenPageLimit = listFragment.size
        }

        binding.vpHome.doSelect {
            binding.navView.menu.getItem(it).isChecked = true
        }

        //初始化底部导航栏
        binding.navView.run {
            setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        binding.vpHome.setCurrentItem(0, false)
                    }
                    R.id.navigation_dashboard -> {
                        binding.vpHome.setCurrentItem(1, false)
                    }
                    R.id.navigation_notifications -> {
                        binding.vpHome.setCurrentItem(2, false)
                    }
                }
                true

            }
        }

    }



    override fun initFragmentViewModel() {
    }


}