package com.orkansahinoglu.socialisebase.Post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.utility.BottomnavigationViewHelper
import kotlinx.android.synthetic.main.activity_home.*

class PostActivity : AppCompatActivity() {
    private val ACTIVITY_NO=2
    private val TAG="PostActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

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