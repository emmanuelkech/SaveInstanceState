package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private  var inputName = " "
    private   var email  = " "
    private   var whatIDo  = " "
    private   var phoneNumber = " "

    companion object {
        const val TAG = "MainActivity"
        const val KEY_FULL_NAME ="full name"
        const val KEY_EMAIL = "email"
        const val KEY_WHAT_I_DO = "what i do"
        const val KEY_PHONE_NUMBER = "phone number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Log.d(TAG, "onCreate called")
        setContentView(binding.root)

        val inputName:EditText = binding.inputLayout1Txt
        val email:EditText = binding.inputLayout2Txt
        val whatIDo:EditText = binding.inputLayout3Txt
        val phoneNumber:EditText = binding.inputLayout4Txt
        val viewName:TextView = binding.viewName
        val viewEmail:TextView = binding.viewEmail
        val viewWhatIDo:TextView = binding.viewWhatIDo
        val viewPhoneNumber:TextView = binding.viewPhoneNumber
        val submitButton:Button = binding.button


        submitButton.setOnClickListener {

            viewName.text = inputName.text.toString()
            inputName.text = null

            viewEmail.text = email.text.toString()
            email.text = null

            viewWhatIDo.text = whatIDo.text.toString()
            whatIDo.text = null

            viewPhoneNumber.text = phoneNumber.text.toString()
            phoneNumber.text = null
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        //for the EditText
        inputName = savedInstanceState.getString(KEY_FULL_NAME, " ")
        email = savedInstanceState.getString(KEY_EMAIL, " ")
        whatIDo = savedInstanceState.getString(KEY_WHAT_I_DO, " ")
        phoneNumber = savedInstanceState.getString(KEY_PHONE_NUMBER, " ")

        //for the TextView
        val nameView = binding.viewName
        nameView.text = savedInstanceState.getString(KEY_FULL_NAME)
        val emailView = binding.viewEmail
        emailView.text = savedInstanceState.getString(KEY_EMAIL)
        val jobView = binding.viewWhatIDo
        jobView.text = savedInstanceState.getString(KEY_WHAT_I_DO)
        val phoneView = binding.viewPhoneNumber
        phoneView.text = savedInstanceState.getString(KEY_PHONE_NUMBER)

        Log.d( TAG, "onRestoreInstanceState Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //for the EditText
        outState.putString(KEY_FULL_NAME, inputName)
        outState.putString(KEY_EMAIL, email)
        outState.putString(KEY_WHAT_I_DO, whatIDo)
        outState.putString(KEY_PHONE_NUMBER, phoneNumber)

        //for the TextView
        val nameView = binding.viewName.text
        outState.putString(KEY_FULL_NAME, nameView.toString() )
        val emailView = binding.viewEmail.text
        outState.putString(KEY_EMAIL, emailView.toString() )
        val jobView = binding.viewWhatIDo.text
        outState.putString(KEY_WHAT_I_DO, jobView.toString() )
        val phoneView = binding.viewPhoneNumber.text
        outState.putString(KEY_PHONE_NUMBER, phoneView.toString() )

        Log.d( TAG, "onSaveInstanceState Called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onCreate called")
    }

    override fun onResume() {
        super.onResume()
        Log.d( TAG, "onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d( TAG, "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d( TAG, "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d( TAG, "onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d( TAG, "onRestart Called")
    }

}