package com.joy.yariklabexample.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment

interface FragmentInstance

interface FragmentInstanceParams : FragmentInstance {

    fun newInstance(bundle: Bundle): Fragment
}

interface FragmentInstanceEmpty : FragmentInstance {

    fun newInstance(): Fragment
}