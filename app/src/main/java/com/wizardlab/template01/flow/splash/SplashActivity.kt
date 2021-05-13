package com.wizardlab.template01.flow.splash

import android.view.View
import androidx.databinding.DataBindingUtil
import com.wizardlab.template01.R
import com.wizardlab.template01.base.BaseActivity
import com.wizardlab.template01.databinding.ActivityBaseBinding
import com.wizardlab.template01.databinding.ActivitySplashBinding
import com.wizardlab.template01.flow.main.MainActivity
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Template01
 * Class: SplashActivity
 * Created by Wizardlab
 *
 * Description: initLayout() -> checkPermission() -> permissionOK() -> showNextScreen()
 */
class SplashActivity : BaseActivity<SplashContract.View,
        SplashPresenter>(),
    SplashContract.View {

    private lateinit var binding: ActivitySplashBinding
    override var presenter: SplashPresenter = SplashPresenter()
    private var loadingDisposable: Disposable? = null

    override fun initLayout() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        super.initLayout(binding.root)

        presenter.checkPermission()
    }

    override fun setupActionBar(baseBinding: ActivityBaseBinding) {
        baseBinding.layoutAppbar.visibility = View.GONE
    }

    override fun versionOk() {
        //TODO("Not yet implemented")
    }

    override fun permissionOk() {
        loadingDisposable = Completable.timer(2, TimeUnit.SECONDS, Schedulers.io())
            .subscribe { showNextScreen() }
    }

    private fun showNextScreen() {
        startActivity(MainActivity.newInstance(this))
    }

    override fun onDestroy() {
        loadingDisposable?.takeIf { !it.isDisposed }?.let {
            loadingDisposable?.dispose()
        }

        super.onDestroy()
    }
}