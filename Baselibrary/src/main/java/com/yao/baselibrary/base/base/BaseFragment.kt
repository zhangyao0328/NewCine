package com.yao.baselibrary.base.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 *  @author zhangyao
 *  @date 2021/10/21  09:26
 *  @E-mail android_n@163.com
 */
abstract class BaseFragment<VB : ViewBinding>(var inflater: (LayoutInflater, ViewGroup?, Boolean) -> VB) :
    Fragment() {

    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //由于同一个fragment对象可能被activity attach多次(比如viewPager+PagerStateAdapter中)
        //所以fragmentViewModel不能放在onCreateView初始化，否则会产生多个fragmentViewModel
        initFragmentViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflater(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
        //observe一定要在初始化最后，因为observe会收到黏性事件，随后对ui做处理
        observe()
        onClick()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    open fun observe(){

    }

    open fun onClick(){

    }

    /**
     * 初始化入口
     */
    abstract fun init(savedInstanceState: Bundle?)

    /**
     * 初始话viewMode
     */
    abstract fun initFragmentViewModel()
}