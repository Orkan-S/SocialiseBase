package com.orkansahinoglu.socialisebase.Profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nostra13.universalimageloader.core.ImageLoader
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.utility.UniversalImageLoader
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_edit_profile.view.*


// A simple [Fragment] subclass.

class EditProfileFragment : Fragment() {

    lateinit var circleImageViewFragment:CircleImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)

        circleImageViewFragment=view.circleImageView

        setupProfilePicture()

        view.imgCancel.setOnClickListener {

            activity?.onBackPressed()
        }
        return view
    }

    private fun setupProfilePicture() {
        //https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png
        var imgURL = "cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"
        UniversalImageLoader.setImage(imgURL, circleImageViewFragment, null, ilkKisim = "https://")

    }
}



