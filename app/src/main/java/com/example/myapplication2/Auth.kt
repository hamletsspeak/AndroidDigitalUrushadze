package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Auth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val linktoreg:TextView=findViewById(R.id.linktoreg)
        linktoreg.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        val user_login = findViewById<EditText>(R.id.user_login_auth)
        val user_pass = findViewById<EditText>(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)

        button.setOnClickListener{
            val login = user_login.text.toString().trim()
            val pass = user_pass.text.toString().trim()
            if (login == ""|| pass == ""){
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
            }
            else {
                val db=Dbhelperr(this,null)
                val isAuth= db.getUser(login, pass)
                if(isAuth) {
                    Toast.makeText(this, "User $login authorised!", Toast.LENGTH_SHORT).show()
                    user_login.text.clear()
                    user_pass.text.clear()
                    val intent = Intent(this, activity_items::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "User $login not found!", Toast.LENGTH_SHORT).show()
            }


        }

    }
    }


}