package test.jobhopin.com.testlanguage

import test.jobhopin.com.testlanguage.MyApplication.Companion.getGlobalSharedPreference

/**
 * Created by Nguyen on 3/25/21
 */
object SharedPreferenceHelper {

    const val LANGUAGE = "language"

    fun getDefaultLanguage(): String? {
        return getGlobalSharedPreference().getString(LANGUAGE, "en")
    }

    fun setDefaultLanguage(locale: String) {
        getGlobalSharedPreference().edit().putString(LANGUAGE, locale).apply()
    }
}
