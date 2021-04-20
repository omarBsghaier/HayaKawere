package com.example.HayaKawere.view.activities


import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.HayaKawere.R
import com.example.HayaKawere.dao.GestionUserDao
import com.example.HayaKawere.dao.callBack.APiResponseStandardCallBack
import com.example.HayaKawere.entities.StandardResponse
import com.example.HayaKawere.entities.userLogin
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import retrofit2.Response
import java.util.*


const val RC_SIGN_IN = 123


 class LoginActivity : AppCompatActivity() {
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var  connect : Button
    lateinit var show_password : ImageView



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
        show_password=findViewById(R.id.iv_show_password_login_activity)

        // SHOW PASSWORD & HIDE PASSWORD
        show_password.setOnClickListener(object :  View.OnClickListener{
            var  passwordShown = false;
            override fun onClick(v: View?) {

                if( passwordShown == false ){
                show_password.setImageDrawable(getDrawable(R.drawable.show_password))
                    password.transformationMethod = HideReturnsTransformationMethod.getInstance();

                    password.setSelection(password.text.length)
                passwordShown = true }
                else {

                    show_password.setImageDrawable(getDrawable(R.drawable.show_hide_password))
                    password.transformationMethod = PasswordTransformationMethod.getInstance();
                    password.setSelection(password.text.length)
                    passwordShown=false

                }
            }

        })



        connect.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                println("button yerdem")

                GestionUserDao.instance().loginWithEmailAndPassword(userLogin(email.text.toString(), password.text.toString()), object : APiResponseStandardCallBack {
                        override fun success(response: Response<StandardResponse>) {
                            println(response.body())


                            if (response.code() == 200) {
                               var intent = Intent(this@LoginActivity, AcceuilActivity::class.java)
                               startActivity(intent)
                                println("trdemich")



                            }


                        }


                        override fun failure(t: Throwable) {
                            println("metrdemich"+ t.message)

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


    }
    fun loginToCreate(view: View) {
        val intent = Intent(this, CreateCompteActivity::class.java)
        startActivity(intent)

    }


}


