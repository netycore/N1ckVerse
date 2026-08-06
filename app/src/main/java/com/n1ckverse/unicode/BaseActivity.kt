package com.n1ckverse.unicode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

/**
 * Base activity that applies the correct theme from user preferences.
 *
 * Theme mapping (stored as string key in SharedPreferences under "theme"):
 *   "dark"      → Theme (AppCompat Dark)
 *   "light"     → Theme.Light
 *   "darktitle" → Theme.Light.DarkActionBar  (default)
 *   "daynight"  → Theme.DayNight  (follows system dark mode)
 *   "amoled"    → Theme.AMOLED  (pure black for OLED)
 */
abstract class BaseActivity : AppCompatActivity() {

    private var currentThemeKey: String? = null

    private fun getThemeKeyFromPref(): String {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        // Legacy numeric IDs are mapped to string keys on first load
        return pref.getString("theme", null)?.let { raw ->
            when (raw) {
                // Legacy numeric resource ID mappings (kept for backward compat)
                "2131492983" -> "dark"
                "2131492984" -> "light"
                "2131492985" -> "darktitle"
                "2131492986" -> "daynight"
                // New string-based keys
                "dark", "light", "darktitle", "daynight", "amoled" -> raw
                else -> "darktitle"
            }
        } ?: "darktitle"
    }

    private fun applyThemeForKey(key: String) {
        val styleRes = when (key) {
            "dark"      -> R.style.Theme
            "light"     -> R.style.Theme_Light
            "darktitle" -> R.style.Theme_Light_DarkActionBar
            "daynight"  -> R.style.Theme_DayNight
            "amoled"    -> R.style.Theme_AMOLED
            else        -> R.style.Theme_Light_DarkActionBar
        }
        setTheme(styleRes)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        currentThemeKey = getThemeKeyFromPref().also { applyThemeForKey(it) }
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        val newKey = getThemeKeyFromPref()
        if (currentThemeKey != newKey) {
            recreate()
        }
    }
}
