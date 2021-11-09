package com.cine.newcine

import com.cine.newcine.databinding.ActivityMainBinding
import com.yao.baselibrary.base.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun initView() {

    }

    override fun onSupportNavigateUp(): Boolean {
        return true
    }


}