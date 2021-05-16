package com.orkansahinoglu.socialisebase.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nostra13.universalimageloader.core.ImageLoader
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.utility.BottomnavigationViewHelper
import com.orkansahinoglu.socialisebase.utility.HomePagerAdapter
import com.orkansahinoglu.socialisebase.utility.UniversalImageLoader
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val ACTIVITY_NO=0
    private val TAG="HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initImageLoader()
        setupNavigationView()
        setupHomeViewPager()
    }

     fun setupNavigationView(){

       BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
       BottomnavigationViewHelper.setupNavigation(this,bottomNavigationView)
         var menu=bottomNavigationView.menu
         var menuItem=menu.getItem(ACTIVITY_NO)
         menuItem.setChecked(true)
    }
    private fun setupHomeViewPager()
    {
        var homePagerAdapter=HomePagerAdapter(supportFragmentManager)
        homePagerAdapter.addFragment(CameraFragment())//id=0
        homePagerAdapter.addFragment(HomeFragment())//id=1
        homePagerAdapter.addFragment(MessageFragment())//id=2

        //activity mainde bulunan viewpager a oluşturduğumuzu adaptörü atadık
        homeViewPager.adapter = homePagerAdapter
        //viewpagerinm home ile başlaması için sağladık
        homeViewPager.setCurrentItem(1)
    }
    private fun initImageLoader(){
        var universalImageLoader= UniversalImageLoader(this)
        ImageLoader.getInstance().init(universalImageLoader.config)
    }
}