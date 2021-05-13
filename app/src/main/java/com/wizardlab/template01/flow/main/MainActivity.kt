package com.wizardlab.template01.flow.main

import android.content.Context
import android.content.Intent
import android.view.View
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

    companion object {
        fun newInstance(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun initLayout() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.handler = this
        binding.presenter = presenter

        super.initLayout(binding.root)
    }

    override fun setupActionBar(baseBinding: ActivityBaseBinding) {
        baseBinding.layoutAppbar.visibility = View.VISIBLE
        baseBinding.tvTitle.visibility = View.VISIBLE
        baseBinding.tvTitle.text = getString(R.string.title_mainActivity)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
        finish()
        android.os.Process.killProcess(android.os.Process.myPid())
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}