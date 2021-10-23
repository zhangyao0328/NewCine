package com.cine.newcine.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cine.newcine.databinding.FragmentHomeBinding
import com.yao.baselibrary.base.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var homeViewModel: HomeViewModel

    override fun init(savedInstanceState: Bundle?) {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.text.value

    }

    override fun initFragmentViewModel() {
//        TODO("Not yet implemented")
    }


}