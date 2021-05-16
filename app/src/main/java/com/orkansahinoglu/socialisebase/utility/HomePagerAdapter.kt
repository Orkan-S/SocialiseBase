package com.orkansahinoglu.socialisebase.utility

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private var mFragmentList: ArrayList<Fragment> = ArrayList()

    //fragment pager adaptor un yazmayı zorunlu kıldığı fonksiyon
    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)


    }   //fragment pager adapter un yazmayı zorunlu kıldığı fonksiyon

    override fun getCount(): Int {
        return mFragmentList.size

    }

    //kişisel fonksiyon
    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }

}