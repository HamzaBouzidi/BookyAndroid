package com.example.booky.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.booky.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    lateinit var usernameLayout: TextInputLayout;
    lateinit var passwordLayout: TextInputLayout;
    lateinit var usernameEditText: EditText;
    lateinit var passwordEditText: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        usernameLayout = findViewById(R.id.username_tfLayout)
        passwordLayout = findViewById(R.id.password_tfLayout)
        usernameEditText = findViewById(R.id.usernameEditText)
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
            if (validateLogin(usernameEditText, passwordEditText,passwordLayout)) {
              //  login(usernameEditText.text.trim().toString(), passwordEditText.text.trim().toString())

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
}