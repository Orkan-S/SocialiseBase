package com.orkansahinoglu.socialisebase.utility

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx
import com.orkansahinoglu.socialisebase.Home.HomeActivity
import com.orkansahinoglu.socialisebase.Notifications.NotificationsActivity
import com.orkansahinoglu.socialisebase.Post.PostActivity
import com.orkansahinoglu.socialisebase.Profile.ProfileActivity
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.Search.SearchActivity
import java.security.AccessControlContext

class BottomnavigationViewHelper {

    companion object {

        fun setupBottomNavigationView(bottomnavigationViewEx: BottomNavigationViewEx){

            bottomnavigationViewEx.enableAnimation(false)
            bottomnavigationViewEx.enableItemShiftingMode(false)
            bottomnavigationViewEx.enableShiftingMode(false)
            bottomnavigationViewEx.setTextVisibility(false)

        }
        fun setupNavigation(context: Context,bottomnavigationViewEx: BottomNavigationViewEx){

            bottomnavigationViewEx.onNavigationItemSelectedListener= object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {

                    when(item.itemId){

                        R.id.home->
                        {
                            val intent= Intent(context,HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.search->
                        {
                            val intent= Intent(context,SearchActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.post->
                        {
                            val intent= Intent(context,PostActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.notifications->
                        {
                            val intent= Intent(context,NotificationsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }
                        R.id.profile->
                        {
                            val intent= Intent(context,ProfileActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                            context.startActivity(intent)
                            return true
                        }

                    }
                    return false
                }


            }
        }
    }
}