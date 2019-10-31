package com.example.advanceauthfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        button_sign_in.setOnClickListener { handleSignIn() }
    }

    private fun handleSignIn() {
        val email = edit_text_email.text.toString()
        val password = edit_text_password.text.toString()
        Firebase.mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful)
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleSignInGoogle() {

    }

}
