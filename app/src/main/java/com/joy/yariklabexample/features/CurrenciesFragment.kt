package com.joy.yariklabexample.features

import androidx.fragment.app.Fragment
import com.joy.yariklabexample.R
import com.joy.yariklabexample.navigation.FragmentInstanceEmpty

class CurrenciesFragment : Fragment(R.layout.fragment_currencies) {

    companion object : FragmentInstanceEmpty {

        override fun newInstance() = CurrenciesFragment()
    }
}