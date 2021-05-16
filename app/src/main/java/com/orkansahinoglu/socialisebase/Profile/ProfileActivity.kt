package com.orkansahinoglu.socialisebase.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.utility.BottomnavigationViewHelper
import com.orkansahinoglu.socialisebase.utility.UniversalImageLoader
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.bottomNavigationView
import kotlinx.android.synthetic.main.activity_profile_settings.*

class ProfileActivity : AppCompatActivity() {
    private val ACTIVITY_NO=4
    private val TAG="ProfileActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupToolbar()
        setupNavigationView()
        setupProfilePhoto()
    }

    private fun setupProfilePhoto() {
        val imgURL="cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"
        UniversalImageLoader.setImage(imgURL,circleProfileImage,null,"https://")
    }

    private fun setupToolbar() {
        imgProfileSettings.setOnClickListener{

            var intent=Intent(this,ProfileSettingsActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

            startActivity(intent)
        }

        twEditProfileButton.setOnClickListener {
            ProfileRoot.visibility=View.GONE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.profileContainer,EditProfileFragment())
            transaction.addToBackStack("editProfileFragmentAdded")
            transaction.commit()
        }

    }

    fun setupNavigationView(){

        BottomnavigationViewHelper.setupBottomNavigationView(bottomNavigationView)
        BottomnavigationViewHelper.setupNavigation(this,bottomNavigationView)
        var menu=bottomNavigationView.menu
        var menuItem=menu.getItem(ACTIVITY_NO)
        menuItem.setChecked(true)
    }

    override fun onBackPressed() {
        ProfileRoot.visibility=View.VISIBLE
        super.onBackPressed()
    }
}