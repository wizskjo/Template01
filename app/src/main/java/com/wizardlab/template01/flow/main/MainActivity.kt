package com.wizardlab.template01.flow.main

import androidx.databinding.DataBindingUtil
import com.wizardlab.template01.R
import com.wizardlab.template01.base.BaseActivity
import com.wizardlab.template01.databinding.ActivityBaseBinding
import com.wizardlab.template01.databinding.ActivityMainBinding

class MainActivity : BaseActivity<MainContract.View,
        MainPresenter>(),
    MainContract.View, MainContract.EventHandler {

    private lateinit var binding: ActivityMainBinding
    override var presenter: MainPresenter = MainPresenter()

    override fun initLayout() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.handler = this
        binding.presenter = presenter

        super.initLayout(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}