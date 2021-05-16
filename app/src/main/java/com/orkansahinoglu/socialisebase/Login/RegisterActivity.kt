package com.orkansahinoglu.socialisebase.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.orkansahinoglu.socialisebase.R
import com.orkansahinoglu.socialisebase.utility.EventbusDataEvents
import kotlinx.android.synthetic.main.activity_register.*
import org.greenrobot.eventbus.EventBus

class RegisterActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    lateinit var manager:FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        manager=supportFragmentManager
        manager.addOnBackStackChangedListener(this)

        init()
    }

    private fun init() {

        twEmail.setOnClickListener {
            viewEmail.visibility= View.VISIBLE
            viewLongShadow.visibility= View.GONE
            etRegisterFirstField.setText("")
            etRegisterFirstField.inputType=InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            etRegisterFirstField.setHint("E-Mail")
            btnRegisterContinue.isEnabled=false

        }

        twPhone.setOnClickListener {
            viewEmail.visibility= View.GONE
            viewLongShadow.visibility= View.VISIBLE
            etRegisterFirstField.setText("")
            etRegisterFirstField.inputType=InputType.TYPE_CLASS_PHONE
            etRegisterFirstField.setHint("PhoneNumber")
            btnRegisterContinue.isEnabled=false


        }
        etRegisterFirstField.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(start+before+count >=10){
                    btnRegisterContinue.isEnabled=true
                    btnRegisterContinue.setTextColor(ContextCompat.getColor(this@RegisterActivity,R.color.white))
                    btnRegisterContinue.setBackgroundResource(R.drawable.register_edit_button_active)
                }
                else{
                    btnRegisterContinue.isEnabled=false
                    btnRegisterContinue.setTextColor(ContextCompat.getColor(this@RegisterActivity,R.color.instablue))
                    btnRegisterContinue.setBackgroundColor(ContextCompat.getColor(this@RegisterActivity,R.color.white_bar))
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        btnRegisterContinue.setOnClickListener{
        if (etRegisterFirstField.hint.toString().equals("PhoneNumber")){

            RegisterRoot.visibility=View.GONE
            RegisterContainer.visibility=View.VISIBLE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.RegisterContainer,PhoneVerificationFragment())
            transaction.addToBackStack("phoneVerificationAdded")
            transaction.commit()
            //alınan field in dönüştürülüp kullanılması için
            EventBus.getDefault().postSticky(EventbusDataEvents.RegisterInfoSender(etRegisterFirstField.text.toString(),null,null,null,false))

        }else{
            RegisterRoot.visibility=View.GONE
            RegisterContainer.visibility=View.VISIBLE
            var transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.RegisterContainer,RegisterNextFragment())
            transaction.addToBackStack("mailRegisterAdded")
            transaction.commit()
            //alınan field in dönüştürülüp kullanılması için
            EventBus.getDefault().postSticky(EventbusDataEvents.RegisterInfoSender(null,etRegisterFirstField.text.toString(),null,null,true))

        }
        }
    }
    override fun onBackStackChanged() {
        val elemanSayisi=manager.backStackEntryCount

        if (elemanSayisi==0){

            RegisterRoot.visibility=View.VISIBLE

        }
    }

}