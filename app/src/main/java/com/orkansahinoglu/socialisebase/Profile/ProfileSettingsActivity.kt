package com.orkansahinoglu.socialisebase.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.utility.BottomnavigationViewHelper
import kotlinx.android.synthetic.main.activity_profile_settings.*


class ProfileSettingsActivity : AppCompatActivity() {

    private val ACTIVITY_NO = 4
    private val TAG = "ProfileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)

        setupToolbar()
        setupNavigationView()
        fragmentNavigations()
    }

    private fun fragmentNavigations() {
        twEditProfileAccOpt.setOnClickListener {
            profileSettingsRoot.visibility=View.GONE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileSettingsContainer,EditProfileFragment())
            transaction.addToBackStack("EditProfileFragmentAdded")
            transaction.commit()
        }
        twLogout.setOnClickListener {
            profileSettingsRoot.visibility=View.GONE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileSettingsContainer,LogoutFragment())
            transaction.addToBackStack("logoutFragmentAdded")
            transaction.commit()
        }
    }

    private fun setupToolbar() {
        imgBack.setOnClickListener {
            onBackPressed()
        }

        }
    override fun onBackPressed() {
        profileSettingsRoot.visibility=View.VISIBLE
            super.onBackPressed()
    }

    fun setupNavigationView() {

        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this, bottomNavigationView)
        var menu = bottomNavigationView.menu
        var menuItem = menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)

    }
}