package com.example.HayaKawere


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.GoogleApiClient


const val RC_SIGN_IN = 123


class LoginActivity : AppCompatActivity() {
    var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //<!--button facebook-->
        callbackManager = CallbackManager.Factory.create()
        var loginButton = findViewById<LoginButton>(R.id.login_button)
        loginButton.setReadPermissions("email")
        // Callback registration
        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
            override fun onSuccess(loginResult: LoginResult?) {
                Toast.makeText(this@LoginActivity, "vous etes connectée ", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onCancel() {

            }

            override fun onError(exception: FacebookException) {

            }
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager!!.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun passer(view: View) {
        val intent = Intent(this, AcceuilActivity::class.java)
        startActivity(intent)

    }

}
