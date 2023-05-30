package com.joy.yariklabexample.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

class NavigatorImpl(
    @IdRes private val containerRes: Int,
    private val fragmentManager: FragmentManager,
    private val animationTransaction: AnimationTransaction? = null,
    private val activityBack: () -> Unit,
) : Navigator {

    override val currentFragment: Fragment?
        get() = fragmentManager.findFragmentById(containerRes)

    override fun startFlow(fragment: Fragment) {
        fragmentManager.commit {
            this.replace(containerRes, fragment)
            setReorderingAllowed(true)
        }
    }

    override fun replaceFragment(fragment: Fragment) {
        fragmentManager.commit {
            if (animationTransaction != null) {
                this.setCustomAnimations(
                    animationTransaction.enter,
                    animationTransaction.exit,
                    animationTransaction.popEnter,
                    animationTransaction.popExit
                )
            }
            this.replace(containerRes, fragment)
            addToBackStack(null)
            setReorderingAllowed(true)
        }
    }

    override fun addFragment(fragment: Fragment) {
        fragmentManager.commit {
            if (animationTransaction != null) {
                this.setCustomAnimations(
                    animationTransaction.enter,
                    animationTransaction.exit,
                    animationTransaction.popEnter,
                    animationTransaction.popExit
                )
            }
            this.add(containerRes, fragment)
            addToBackStack(null)
            setReorderingAllowed(true)
        }
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            activityBack()
        }
    }
}