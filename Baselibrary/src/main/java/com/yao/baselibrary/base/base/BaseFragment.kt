package com.yao.baselibrary.base.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/**
 *  @author zhangyao
 *  @date 2021/10/21  09:26
 *  @E-mail android_n@163.com
 */
abstract class BaseFragment<VB : ViewBinding>(var inflater: (LayoutInflater, ViewGroup?, Boolean) -> VB) :
    Fragment() {

    /**
     * 开放给外部使用
     */
    lateinit var mContext: Context
    lateinit var mActivity: AppCompatActivity
     var activityProvider : ViewModelProvider? = null

    private var _binding: VB? = null
    val binding: VB get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //由于同一个fragment对象可能被activity attach多次(比如viewPager+PagerStateAdapter中)
        //所以fragmentViewModel不能放在onCreateView初始化，否则会产生多个fragmentViewModel
        initFragmentViewModel()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mActivity = context as AppCompatActivity

        //必须要在activity与fragment绑定后，因为fragment可能获取的是 activity中的viewModel
        //必须在onCreateView之前初始化viewModel，因为onCreateView中需要通过viewModel与DataBinding绑定
        initViewModel()

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


    /**
     * 初始化入口
     */
    abstract fun init(savedInstanceState: Bundle?)


    /**
     * 初始化viewMode
     * 之所以没有设计为抽象，是因为部分简单activity可能不需要viewModel
     * observe同理
     */
    open fun initViewModel() {

    }


    abstract fun initFragmentViewModel()

    /**
     * 注册观察者
     */
    open fun observe() {

    }

    /**
     * 注册点击事件
     */
    open fun onClick() {

    }

    /**
     * 通过activity获取viewModel，跟随activity生命周期
     */
    protected fun <T:ViewModel?> getActivityViewModel(modelClass: Class<T>) : T{

        if(activityProvider == null){
            activityProvider  = ViewModelProvider(mActivity)
        }

        return activityProvider!!.get(modelClass)
    }


}