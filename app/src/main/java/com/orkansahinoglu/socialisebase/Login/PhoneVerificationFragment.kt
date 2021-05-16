package com.orkansahinoglu.socialisebase.Login

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.utility.EventbusDataEvents
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_phone_verification.*
import kotlinx.android.synthetic.main.fragment_phone_verification.view.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import java.util.concurrent.TimeUnit


class PhoneVerificationFragment : Fragment() {

    var incomingPhoneNo=""
    lateinit var mCallbacks:PhoneAuthProvider.OnVerificationStateChangedCallbacks
    var  verificationID=""
    var incomingCode=""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        var view= inflater.inflate(R.layout.fragment_phone_verification, container, false)

        view.twUserPhoneNo.setText(incomingPhoneNo)

        setupCallBack()
        view.btnPhoneCodeNext.setOnClickListener{
            if(incomingCode.equals(view.etConfirmationCode.text.toString())) {

                EventBus.getDefault().postSticky(EventbusDataEvents.RegisterInfoSender(etRegisterFirstField.text.toString(),null,null,null,false))
                var transaction = activity!!.supportFragmentManager.beginTransaction()
                transaction.replace(R.id.RegisterContainer, RegisterNextFragment())
                transaction.addToBackStack("registerNextFragmentAdded")
                transaction.commit()
            }

            else{
                Toast.makeText(activity,"Code is incorrect",Toast.LENGTH_SHORT).show()
            }
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            incomingPhoneNo, //doğrulancak tel no
            60,        //timeout süre sınırı
        TimeUnit.SECONDS,       //timeout süresi cinsi
            this.activity!!,          //callback bağlamı döndüreceği aktivite
        mCallbacks)



        
        return view
    }
    private fun setupCallBack(){
        mCallbacks= object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                incomingCode=credential.smsCode!!


            }

            override fun onVerificationFailed(e: FirebaseException) {

            }

            override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                verificationID=verificationId!!

            }
        }


    }

    @Subscribe(sticky = true)
    internal fun onPhoneNoEvent(registerInfo: EventbusDataEvents.RegisterInfoSender){

        incomingPhoneNo=registerInfo.phoneNo!!
        Log.e("orkan","Incoming PhoneNumber: "+incomingPhoneNo)

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
