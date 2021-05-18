package com.wizardlab.template01.flow.main

import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
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

        binding.tvExample.setOnClickListener {
            if(binding.viewCompanyLogo.visibility == View.GONE) {
                binding.viewCompanyLogo.visibility = View.VISIBLE
            } else {
                binding.viewCompanyLogo.visibility = View.GONE
            }
        }

    }

    override fun setupActionBar(baseBinding: ActivityBaseBinding) {
        baseBinding.layoutAppbar.visibility = View.VISIBLE
        baseBinding.ivTitle.visibility = View.VISIBLE
        baseBinding.viewLine.visibility = View.VISIBLE
        baseBinding.ivLeft.visibility = View.VISIBLE
        baseBinding.ivLeft.setOnClickListener { onBackPressed() }
        baseBinding.ivRight.visibility = View.VISIBLE
        baseBinding.ivRight.setOnClickListener {
            if(!baseBinding.layoutDrawer.isDrawerOpen(Gravity.LEFT)) {
                baseBinding.layoutDrawer.openDrawer(Gravity.LEFT)
            } else {
                baseBinding.layoutDrawer.closeDrawer(Gravity.LEFT)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishApp()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}