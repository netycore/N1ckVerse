package com.n1ckverse.unicode

import android.app.Activity
import android.content.SharedPreferences

internal interface AdCompat {
  fun renderAdToContainer(activity: Activity, pref: SharedPreferences)
  val showAdSettings: Boolean
}
