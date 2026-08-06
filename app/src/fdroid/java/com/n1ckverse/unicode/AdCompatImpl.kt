package com.n1ckverse.unicode

import android.app.Activity
import android.content.SharedPreferences

internal class AdCompatImpl : AdCompat {
    override val showAdSettings = false
    override fun renderAdToContainer(activity: Activity, pref: SharedPreferences) {
    }
}
