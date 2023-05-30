package com.joy.yariklabexample.navigation

import androidx.fragment.app.Fragment

interface Navigator {

    val currentFragment: Fragment?

    fun startFlow(fragment: Fragment)

    fun replaceFragment(fragment: Fragment)

    fun addFragment(fragment: Fragment)

    fun onBackPressed()
}