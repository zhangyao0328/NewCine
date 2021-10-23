package com.yao.baselibrary.base.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 *  @author zhangyao
 *  @date 2021/10/20  12:04
 *  @E-mail android_n@163.com
 */
abstract class BaseActivity<VB : ViewBinding>(
    val inflater: (LayoutInflater) -> VB
) : AppCompatActivity() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflater(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    abstract fun initView()

}