package com.example.stepper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle ): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        // Cantidad de fragments
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> OneFragment()
            1 -> TwoFragment()
            2 -> ThreeFragment()
            else -> OneFragment()
        }
    }

}