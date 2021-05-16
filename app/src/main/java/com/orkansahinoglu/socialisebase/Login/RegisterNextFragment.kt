package com.orkansahinoglu.socialisebase.Login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.utility.EventbusDataEvents
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class RegisterNextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_next, container, false)
    }

    @Subscribe(sticky = true)
    internal fun onPhoneNoEvent(registerInfo: EventbusDataEvents.RegisterInfoSender){

        var incomingEmailAddress=registerInfo.email
        Log.e("orkan","Incoming EmailAdress: "+incomingEmailAddress)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        EventBus.getDefault().register(this)
    }

    override fun onDetach() {
        super.onDetach()
        EventBus.getDefault().unregister(this)
    }
}