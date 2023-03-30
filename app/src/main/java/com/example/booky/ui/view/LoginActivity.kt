package com.example.booky.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.booky.R
import com.example.booky.data.api.RestApiService
import com.example.booky.data.api.RetrofitInstance
import com.example.booky.data.models.User
import com.example.booky.utils.LoadingDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var userEmailLayout: TextInputLayout;
    lateinit var passwordLayout: TextInputLayout;
    lateinit var userEmailEditText: EditText;
    lateinit var passwordEditText: EditText;
    lateinit var loadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        userEmailLayout = findViewById(R.id.userEmail_tfLayout)
        passwordLayout = findViewById(R.id.password_tfLayout)
        userEmailEditText = findViewById(R.id.userEmailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)



        // Redirect To Register Screen

        val registerBtn = findViewById<TextView>(R.id.register_link)
    /*    registerBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
*/
        // Login Button Handler

        val loginBtn = findViewById<Button>(R.id.login_btn)
        loginBtn.setOnClickListener() {
            if (validateLogin(userEmailEditText, passwordEditText,passwordLayout)) {
                login(userEmailEditText.text.trim().toString(), passwordEditText.text.trim().toString())

            }else{
                val toast = Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT)
                toast.show()
            }

        }




    }
    // Validate User Input
    private fun validateLogin(username: EditText, password: EditText,passwordlayout : TextInputLayout): Boolean {
        if(username.text.trim().isEmpty() || password.text.trim().isEmpty()){

            if (password.text.isEmpty()) {
                password.error = "Password is required"
                password.requestFocus()

            }
            // made it revesed so it desplays correctly you ll see it in the app
            if (username.text.isEmpty()) {
                username.error = "Username is required"
                username.requestFocus()

            }

            return false

        }

        return true
    }


    private fun login(email: String, password: String) {
        loadingDialog.startLoadingDialog()
        val retIn = RetrofitInstance.getRetrofitInstance().create(RestApiService::class.java)
        val signInInfo = User(email, password)

        retIn.loginUser(signInInfo).enqueue(object : Callback<ResponseBody> {

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loadingDialog.dismissDialog()
                Toast.makeText(
                    this@LoginActivity,
                    "Login Failed",
                    Toast.LENGTH_SHORT
                ).show()


            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    loadingDialog.dismissDialog()
                    Toast.makeText(this@LoginActivity, "Welcome!", Toast.LENGTH_SHORT).show()
                    finish()

                } else if(response.code() == 401){
                    loadingDialog.dismissDialog()
                    Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
                else{
                    loadingDialog.dismissDialog()
                    Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}