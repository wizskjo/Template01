package com.wizardlab.template01.util

import android.content.Context
import android.content.SharedPreferences




/**
 * Template01
 * Class: ShardPreferencsUtil
 * Created by Wizardlab
 *
 * Description:
 */
object SharedPreferencesUtil {
    private var sharedPreferencesUtil: SharedPreferences? = null

    fun init(context: Context) {
        sharedPreferencesUtil = context.getSharedPreferences(
            "prefs_name",
            0
        )
    }

    const val KEY_SAVED_BLE_DEVICES = "KEY_SAVED_BLE_DEVICES"
    const val KEY_LAST_TRY_CONNECT_MAC_ADDRESS = "KEY_CONNECTED_MAC_ADDRESS"
    const val KEY_PATIENT_UID = "KEY_PATIENT_UID"
    const val KEY_TOKEN = "KEY_TOKEN"
    const val KEY_CONNECTED_DEVICE_TYPE = "KEY_CONNECTED_DEVICE_TYPE"
    const val KEY_SERIAL_NUMBER = "KEY_SERIAL_NUMBER"
    const val KEY_DEVICE_UID = "KEY_DEVICE_UID"
    const val KEY_ALARM_STRING = "KEY_ALARM_STRING"
    const val KEY_ALARM_HOUR = "KEY_ALARM_HOUR"
    const val KEY_ALARM_MINUTE = "KEY_ALARM_MINUTE"
    const val KEY_BLE_DEVICE_NAME = "KEY_BLE_DEVICE_NAME"
    const val KEY_META_INDEX = "KEY_META_INDEX"
    const val KEY_META_TIME = "KEY_META_TIME"
    const val KEY_META_HR = "KEY_META_HR"

    private fun getSharedPreferences(): SharedPreferences? {
        return sharedPreferencesUtil
    }

    fun setSharedPreferencesString(key: String?, value: String?) {
        sharedPreferencesUtil!!.edit().putString(key, value).apply()
    }

    fun setSharedPreferencesFloat(key: String?, value: Float?) {
        if (value != null) {
            sharedPreferencesUtil!!.edit().putFloat(key, value).apply()
        }
    }

    fun setSharedPreferencesBoolean(key: String?, value: Boolean) {
        sharedPreferencesUtil!!.edit().putBoolean(key, value).apply()
    }

    fun getString(name: String?, defaultValue: String?): String? {
        return getSharedPreferences()?.getString(name, defaultValue)
    }

    fun getBoolean(name: String, defaultValue: Boolean = false): Boolean {
        return getSharedPreferences()?.getBoolean(name, defaultValue) ?: defaultValue
    }

    fun getFloat(name: String?, defaultValue: Float?): Float? {
        return defaultValue?.let { getSharedPreferences()?.getFloat(name, it) }
    }

    fun getSharedPreferencesString(key: String?): String? {
        return getString(key, null as String?)
    }

    fun getSharedPreferencesFloat(key: String?): Float? {
        return getFloat(key, null as Float?)
    }

    fun setSharedPreferenceInt(key: String, value: Int) {
        sharedPreferencesUtil!!.edit().putInt(key, value).apply()
    }

    fun getInt(name: String, defaultValue: Int): Int {
        return getSharedPreferences()?.getInt(name, defaultValue)!!
    }
}