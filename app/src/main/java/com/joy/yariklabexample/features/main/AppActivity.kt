package com.joy.yariklabexample.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joy.yariklabexample.R
import com.joy.yariklabexample.features.CurrenciesFragment
import com.joy.yariklabexample.navigation.BackPressedListener
import com.joy.yariklabexample.navigation.Navigator
import com.joy.yariklabexample.navigation.NavigatorImpl
import com.joy.yariklabexample.navigation.navigation.Navigation

class AppActivity : AppCompatActivity(R.layout.activity_app), Navigation {

    companion object {
        private const val KEY_PID = "MAIN_ACTIVITY_PID"
    }

    private var _navigator: Navigator? = null

    override val navigator: Navigator
        get() = requireNotNull(_navigator)

    override fun onCreate(savedInstanceState: Bundle?) {
        val lastSavedPid = savedInstanceState?.getInt(KEY_PID, 0)
        val currentPid = android.os.Process.myPid()

        _navigator = NavigatorImpl(
            containerRes = R.id.mainContainer,
            fragmentManager = supportFragmentManager,
            animationTransaction = null,
            activityBack = {
                finish()
            }
        )

        if (savedInstanceState == null || lastSavedPid != currentPid) {
            super.onCreate(null)
            navigator.startFlow(CurrenciesFragment.newInstance())
        } else {
            super.onCreate(savedInstanceState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_PID, android.os.Process.myPid())
    }

    override fun onBackPressed() {
        if ((navigator.currentFragment as? BackPressedListener)?.onBackPressed() != true) {
            navigator.onBackPressed()
        }
    }
}