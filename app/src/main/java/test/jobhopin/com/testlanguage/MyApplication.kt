package test.jobhopin.com.testlanguage

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by Nguyen on 3/25/21
 */
class MyApplication : Application() {


    init {
        instance = this
    }

    companion object {
        private var instance: MyApplication? = null

        fun getGlobalSharedPreference(): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(instance!!.applicationContext)
        }

        fun getGlobalContext(): Context? {
            return instance?.applicationContext
        }
    }
}
