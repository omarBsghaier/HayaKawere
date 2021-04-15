package com.example.HayaKawere.view.activities


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.HayaKawere.R
import com.example.HayaKawere.dao.GestionUserDao
import com.example.HayaKawere.dao.callBack.APiResponseStandardCallBack
import com.example.HayaKawere.entities.StandardResponse
import com.example.HayaKawere.view.activities.AcceuilActivity
import com.example.HayaKawere.view.activities.CreateCompteActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import retrofit2.Response
import java.util.*
import kotlin.collections.HashMap


const val RC_SIGN_IN = 123


 class LoginActivity : AppCompatActivity() {
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var  connect : Button



    var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()


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
    fun initView(){
        email = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextTextPassword)
        connect = findViewById(R.id.ConnexionLoginB)


        connect.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                GestionUserDao.instance().loginWithEmailAndPassword( email.text.toString(),password.text.toString(),
                    object : APiResponseStandardCallBack {
                        override fun success(response: Response<StandardResponse>) {
                            println("tekhdeem")
                            println(response.message())
                            println(response.body())





                        }

                        override fun failure(t: Throwable) {

                        }



                    })
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
    fun loginToCreate(view: View) {
        val intent = Intent(this, CreateCompteActivity::class.java)
        startActivity(intent)

    }


}
