package com.wizardlab.template01

import com.polidea.rxandroidble2.LogConstants
import com.polidea.rxandroidble2.LogOptions
import com.polidea.rxandroidble2.RxBleClient
import com.wizardlab.template01.util.SharedPreferencesUtil
import com.zeugmasolutions.localehelper.LocaleAwareApplication


/**
 * Template01
 * Class: MApplication
 * Created by Wizardlab
 *
 * Description:
 */
class MApplication : LocaleAwareApplication() {
    override fun onCreate() {
        super.onCreate()
        instance = this

        rxBleClient = RxBleClient.create(this)
        RxBleClient.updateLogOptions(
            LogOptions.Builder()
                .setLogLevel(LogConstants.INFO)
                .setMacAddressLogSetting(LogConstants.MAC_ADDRESS_FULL)
                .setUuidsLogSetting(LogConstants.UUIDS_FULL)
                .setShouldLogAttributeValues(true)
                .build()
        )
        SharedPreferencesUtil.init(this)
    }
    companion object {
        val TAG = MApplication::class.java.simpleName

        @get:Synchronized
        lateinit var instance: MApplication
            private set

        lateinit var rxBleClient: RxBleClient
            private set
    }
}