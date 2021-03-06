package com.neuronappz.moviesapp.utils

import android.app.Activity
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.showFragment(@IdRes containerId: Int, fragment: Fragment?, addToStack: Boolean = true) {
    //AppLogger.logCurrentMethodName(TAG)
    if (fragment != null) {
        //AppLogger.infoLog(TAG, "Show fragment " + fragment.javaClass.simpleName)
        val fragmentManager = this.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.setCustomAnimations(
//            R.anim.slide_in_left, R.anim.slide_out_left,
//            R.anim.slide_out_right, R.anim.slide_in_right
//        )

        if (addToStack) {
            fragmentTransaction.replace(containerId, fragment)
            fragmentTransaction.addToBackStack(null)
        } else {
            fragmentTransaction.replace(containerId, fragment)
        }
        fragmentTransaction.commit()
    } else {
        //AppLogger.errorLog(TAG, "Fragment intance is NULL")
    }
}