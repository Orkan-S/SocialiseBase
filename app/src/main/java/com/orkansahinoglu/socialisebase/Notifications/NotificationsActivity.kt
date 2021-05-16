package com.orkansahinoglu.socialisebase.Notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.utility.BottomnavigationViewHelper
import kotlinx.android.synthetic.main.activity_home.*

class NotificationsActivity : AppCompatActivity() {
    private val ACTIVITY_NO=3
    private val TAG="NotificationsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        setupNavigationView()
    }

    fun setupNavigationView(){

        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu=bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }
}