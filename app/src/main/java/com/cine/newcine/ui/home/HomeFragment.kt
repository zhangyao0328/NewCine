package com.cine.newcine.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cine.newcine.databinding.FragmentHomeBinding
import com.cine.newcine.ui.home.adapter.ArticleAdapter
import com.yao.baselibrary.base.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private var homeVM: HomeViewModel? = null
    private val adapter by lazy {
        ArticleAdapter(mActivity)
    }

    override fun initViewModel() {
        homeVM = getActivityViewModel(HomeViewModel::class.java)
    }

    override fun init(savedInstanceState: Bundle?) {
        binding.vm = homeVM
    }

    override fun observe() {
        super.observe()
        homeVM?.articalList?.observe(this, Observer {

            adapter.submitList(it)

        })
    }


    override fun initFragmentViewModel() {
    }


    override fun onResume() {
        super.onResume()
        adapter.apply {
            binding.rvHomelist.adapter = this
        }
        homeVM?.setText()
    }


}