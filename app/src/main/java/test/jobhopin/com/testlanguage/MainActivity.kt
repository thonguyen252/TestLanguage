package test.jobhopin.com.testlanguage

import android.content.Context
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private val localeText: String? by lazy { SharedPreferenceHelper.getDefaultLanguage() }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(createLocaleContext(newBase))
    }

    private fun createLocaleContext(context: Context?): Context? {
        val locale = Locale(localeText ?: "en")
        Locale.setDefault(locale)
        return context?.let {
            val conf = it.resources.configuration
            conf.setLocale(locale)
            it.createConfigurationContext(conf)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btToggleLanguage).setOnClickListener {
            toggleLanguage()
        }
    }

    private fun toggleLanguage() {
        val locale = if (localeText == "en") "vi" else "en"
        SharedPreferenceHelper.setDefaultLanguage(locale)
        recreate()
    }
}
