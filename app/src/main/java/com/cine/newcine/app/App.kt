package com.cine.newcine.app

import android.content.Context
import com.github.moduth.blockcanary.BlockCanary
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.api.RefreshLayout
import com.yao.baselibrary.base.BaseApp
import com.yao.baselibrary.base.base.AppBlockCanaryContext
import leakcanary.LeakCanary

class App : BaseApp() {

    override fun onCreate() {
        super.onCreate()

        initBlockCanary()
        initSmartHead()
    }

    private fun initBlockCanary(){
        BlockCanary.install(this, AppBlockCanaryContext()).start()
//        if (!LeakCanary.isInAnalyzerProcess(this)) {
//            LeakCanary.install(this)
//        }
    }

    /**
     * 初始化加载刷新ui
     */
    private fun initSmartHead() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context: Context?, _: RefreshLayout? ->
            ClassicsHeader(context)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context: Context?, _: RefreshLayout? ->
            ClassicsFooter(context)
        }
    }

}