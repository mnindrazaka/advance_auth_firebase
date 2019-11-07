package com.example.advanceauthfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        button_sign_up.setOnClickListener { handleSignup() }
    }

    private fun handleSignup() {
        val email = edit_text_email.text.toString()
        val password = edit_text_password.text.toString()
        Firebase.mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Sign up complete, please sign in", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, SignInActivity::class.java))
            }
            else
                Toast.makeText(this, "Sign up failed " + it.exception.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
