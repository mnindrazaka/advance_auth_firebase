package com.example.advanceauthfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        button_sign_in.setOnClickListener { handleSignIn() }
        button_sign_up.setOnClickListener { handleSignUp() }
    }

    private fun handleSignIn() {
        val email = edit_text_email.text.toString()
        val password = edit_text_password.text.toString()
        Firebase.mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful)
                startActivity(Intent(this, MainActivity::class.java))
            else
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }
}
