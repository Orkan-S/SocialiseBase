package com.orkansahinoglu.socialisebase.utility

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.FragmentActivity
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.FailReason
import com.nostra13.universalimageloader.core.assist.ImageScaleType
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener
import com.orkansahinoglu.socialisebase.R

class UniversalImageLoader(val mContext: FragmentActivity?) {

    val config:ImageLoaderConfiguration
        get(){
            val defaultOptions=DisplayImageOptions.Builder()
                .showImageOnLoading(defaultImage)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .cacheOnDisk(true).cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(FadeInBitmapDisplayer(400)).build()
            return ImageLoaderConfiguration.Builder(mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(WeakMemoryCache())
                .diskCacheSize(100*1024*1024).build()
        }
companion object
    {

    private val defaultImage= R.drawable.tab_profile_foreground

    fun setImage(imgURL:String,imageview:ImageView,mProgressBar:ProgressBar?,ilkKisim:String)
        {
        //imgURL:facebook.com/images/logo.jpg
        //İlkKisim : http:// olcaktır
        val imageLoader=ImageLoader.getInstance()
        imageLoader.displayImage(ilkKisim+imgURL,imageview, object: ImageLoadingListener
            {
            override fun onLoadingStarted(imageUri: String?, view: View?) {

                if (mProgressBar != null) {
                    mProgressBar.visibility = View.VISIBLE

                }
            }

            override fun onLoadingFailed(imageUri: String?, view: View?, failReason: FailReason?) {

                if(mProgressBar!=null){
                    mProgressBar.visibility=View.GONE
                }
            }

            override fun onLoadingComplete(imageUri: String?, view: View?, loadedImage: Bitmap?) {

                if(mProgressBar!=null){
                    mProgressBar.visibility=View.GONE
                }
            }

            override fun onLoadingCancelled(imageUri: String?, view: View?) {

                if(mProgressBar!=null){
                    mProgressBar.visibility=View.GONE
                }


            }


            })
        }
    }
}

