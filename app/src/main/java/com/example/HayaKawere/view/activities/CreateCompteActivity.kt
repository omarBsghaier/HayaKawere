package com.example.HayaKawere.view.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.HayaKawere.R
import com.example.HayaKawere.dao.GestionUserDao
import com.example.HayaKawere.dao.callBack.APiResponseStandardCallBack
import com.example.HayaKawere.entities.StandardResponse
import com.example.HayaKawere.entities.User
import retrofit2.Response
import java.util.*
import java.util.regex.Pattern

class CreateCompteActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var repeat_password: EditText
    lateinit var prenom: EditText
    lateinit var nom: EditText
    lateinit var inscription: Button
    lateinit var msg_email: TextView
    lateinit var msg_nom: TextView
    lateinit var msg_prenom: TextView
    lateinit var msg_motdepasse: TextView
    lateinit var msg_repeat: TextView
     var acces : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_compte)
        initView()

    }

    private fun initView() {
        msg_email = findViewById<TextView>(R.id.tv_msg_email_create_activity)
        msg_nom = findViewById<TextView>(R.id.tv_msg_nom_create_activity)
        msg_prenom = findViewById<TextView>(R.id.tv_msg_prenom_create_activity)
        msg_motdepasse= findViewById<TextView>(R.id.tv_msg_mot_de_passe_create_activity)
        msg_repeat = findViewById<TextView>(R.id.tv_msg_repeter_mot_de_passe_create_activity)

        email = findViewById<EditText>(R.id.ed_email_activity_create)
        password = findViewById<EditText>(R.id.ed_mot_de_passe_create_activity)
        repeat_password=findViewById<EditText>(R.id.ed_repeter_mot_de_passe_create_activity)
        prenom = findViewById<EditText>(R.id.ed_prenomn_activity_create)
        nom = findViewById<EditText>(R.id.ed_nom_activity_create)
        inscription = findViewById<Button>(R.id.bt_inscription_create_activity)

         password.addTextChangedListener(object : TextWatcher {

             override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
             }


             override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
             }


             override fun afterTextChanged(s: Editable?) {
                 if(!Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{5,}\$").matcher(password.text.toString()).matches() )
                 {    msg_motdepasse.visibility = View.VISIBLE
                    acces ++ }
                 else
                 {
                     msg_motdepasse.visibility = View.INVISIBLE
                     acces --
                 }

             }

         })


            repeat_password.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }



            override fun afterTextChanged(s: Editable?) {
                if(!repeat_password.text.toString().equals(password.text.toString()))
                { msg_repeat.visibility = View.VISIBLE
                acces ++}
                else{
                    msg_repeat.visibility = View.INVISIBLE
                acces ++}



            }})

            prenom.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }


            override fun afterTextChanged(s: Editable?) {
                if(prenom.text.toString().length < 3 )
                { msg_prenom.visibility = View.VISIBLE
                acces ++}
                else
                {  msg_prenom.visibility = View.INVISIBLE
                acces --}

            }
        })

        nom.addTextChangedListener(object :  TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }


            override fun afterTextChanged(s: Editable?) {
                if(nom.text.toString().length < 3 )
                {msg_nom.visibility = View.VISIBLE
                    acces ++}
                else{
                    msg_nom.visibility = View.INVISIBLE
                    acces --}


                }

        })
        email.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }


            override fun afterTextChanged(s: Editable?) {
                if (!Pattern.compile(
                        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]|[\\w-]{2,}))@"
                                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9]))|"
                                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
                    ).matcher(email.text.toString()).matches()
                ) { acces ++

                    msg_email.visibility = View.VISIBLE
                }
                else
                    msg_email.visibility = View.INVISIBLE
                    acces --


            }

        })
            inscription.isEnabled =true

            inscription.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    var user: User = User(
                        email.text.toString(),
                        password.text.toString(),
                        "asadadege",
                        "egkfek,",
                        nom.text.toString(),
                        prenom.text.toString()
                    )

                    GestionUserDao.instance().signUpWithEmailAndPassword(user,
                        object : APiResponseStandardCallBack {


                            override fun success(response: Response<StandardResponse>) {
                                println(response.body())
                                println(response.code())


                            }

                            override fun failure(t: Throwable) {


                            }

                        })

                }
            })

    }
}






