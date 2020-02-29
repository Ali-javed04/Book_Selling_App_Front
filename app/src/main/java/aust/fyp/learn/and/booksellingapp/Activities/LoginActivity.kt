package aust.fyp.learn.and.booksellingapp.Activities

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import aust.fyp.learn.and.booksellingapp.R
import aust.fyp.learn.and.booksellingapp.StoreRoom.*
import aust.fyp.learn.and.earn.Interfaces.AlertDialogInterface
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {


    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var progressDialog: ProgressDialog
     var TAG = "LoginActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)

        if (PreferenceManager.getInstance(applicationContext)!!.isUserActive()) {
            if (PreferenceManager.getInstance(applicationContext)!!.getAccountStatus()!!.trim().equals(
                    "unverified"
                )
            ) {
                var intent = Intent(this, VerificationActivity::class.java)
                var pack = Bundle()
                pack.putString("state", "loggeg_in")
                intent.putExtras(pack)
                startActivity(intent)
                finish()
            } else {
                if (PreferenceManager.getInstance(applicationContext)!!.getUserAccountType()!!.trim().equals(
                        Constants.SELLER
                    )
                ) {
                    startActivity(Intent(this, AddSubject::class.java))
                }

            }


        }
    }

             fun openapplication(emailStr: String, passwordStr: String) {

                progressDialog.setMessage("checking account")
                progressDialog.show()



                var request = object : StringRequest(
                    Request.Method.POST, URLs.LOGIN,
                    Response.Listener { response ->


                        try {

                            if (progressDialog != null && progressDialog.isShowing()) {
                                progressDialog.dismiss()
                            }

                            var mainOb = JSONObject(response)
                            var message = mainOb.getString("message")
                            val error = mainOb.getBoolean("error")

                            if (error) {
                                // error
                                Dialogs.showMessage(this, message, "OK", object : AlertDialogInterface {
                                    override fun positiveButtonClick(dialogInterface: DialogInterface) {
                                        dialogInterface.dismiss()
                                    }

                                    override fun negativeButtonClick(dialogInterface: DialogInterface) {
                                    }
                                })
                            } else {
                                var userOb = mainOb.getJSONObject("user")

                                PreferenceManager.getInstance(applicationContext)!!.setActiveUser()
                                PreferenceManager.getInstance(applicationContext)!!
                                    .setUserId(userOb.getInt("ID"))
                                PreferenceManager.getInstance(applicationContext)!!
                                    .setUserName(userOb.getString("name"))
                                PreferenceManager.getInstance(applicationContext)!!
                                    .setUserAddress(userOb.getString("address"))
                                PreferenceManager.getInstance(applicationContext)!!
                                    .setUserPhone(userOb.getString("phone_number"))
                                PreferenceManager.getInstance(applicationContext)!!
                                    .setUserEmail(userOb.getString("email_address"))
                                PreferenceManager.getInstance(applicationContext)!!
                                    .setUserPassword(userOb.getString("password"))
                                PreferenceManager.getInstance(applicationContext)!!
                                    .setUserProfile(userOb.getString("profile_addresss"))
                                PreferenceManager.getInstance(applicationContext)!!
                                    .setAccountStatus(userOb.getString("status"))



                                        startActivity(Intent(this, MainActivity::class.java))

                                    finish()

                            }
                        } catch (e: Exception) {
                            Log.i(TAG, "exception : " + e);
                            Dialogs.showMessage(this, Constants.error_message_exception)
                        }


                    },
                    Response.ErrorListener { error ->
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss()
                        }
                        Log.i(TAG, "error : " + error);
                        Dialogs.showMessage(this, Constants.error_message_volley)
                    }) {
                    override fun getParams(): MutableMap<String, String> {
                        var map = HashMap<String, String>()
                        map["email"] = emailStr
                        map["password"] = passwordStr
                        return map
                    }
                }

                RequestHandler.getInstance(applicationContext)!!.addToRequestQueue(request)



        }

        fun login(view: View) {

            val email_str = email.text.toString().trim()
            val password_str = password.text.toString().trim()

            var isError = false

            if (password_str.isEmpty() || password_str.length < 8) {
                isError = true
                password.error = "please enter the password having minimum 8 charcters"
                password.requestFocus()
            }

            if (email_str.isEmpty()) {
                isError = true
                email.error = "please enter your email"
                email.requestFocus()
            }

            if (!isError) {
                openapplication(email_str, password_str)
            }

        }




    fun create_account(view: View) {

        startActivity(Intent(applicationContext, CreateAccount::class.java))


    }}


