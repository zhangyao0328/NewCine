package com.cine.newcine.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.cine.newcine.common.smartConfig
import com.cine.newcine.common.smartDismiss
import com.cine.newcine.databinding.FragmentHomeBinding
import com.cine.newcine.ui.home.adapter.ArticleAdapter
import com.yao.baselibrary.base.base.LazyVmFragment

class HomeFragment : LazyVmFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

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
        homeVM?.articalList?.observe(this, Observer {
            binding.smartRefresh.smartDismiss()
            adapter.submitList(it)
        })

    }


    override fun initFragmentViewModel() {
    }


    override fun lazyInit() {
        initView()
        loadData()

    }

    override fun initView() {
        adapter.apply {
            binding.rvHomelist.adapter = this
            binding.smartRefresh.smartConfig()
            binding.smartRefresh.setOnRefreshListener {
                homeVM?.getArticle()
            }
            binding.smartRefresh.setOnLoadMoreListener {
                homeVM?.getArticle()
            }
        }

        fun loadData() {
            homeVM?.getArticle()
        }


        fun onClick() {
            binding.tvTtile.setOnClickListener {
                binding.smartRefresh.autoRefresh()
            }
        }
    }
}