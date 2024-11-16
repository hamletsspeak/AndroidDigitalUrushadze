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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val linktoauth:TextView=findViewById(R.id.linktoauth)
        linktoauth.setOnClickListener {
            val intent = Intent(this, Auth::class.java)
            startActivity(intent)
        }

        val user_login = findViewById<EditText>(R.id.user_login)
        val user_email = findViewById<EditText>(R.id.user_email)
        val user_pass = findViewById<EditText>(R.id.user_pass)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener{
            val login = user_login.text.toString().trim()
            val email = user_email.text.toString().trim()
            val pass = user_pass.text.toString().trim()
            if (login == ""|| email == ""|| pass == ""){
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
            }
                else {
                    val user=User(login, email, pass)
                    val db=Dbhelperr(this,null)
                    db.addUser(user)
                Toast.makeText(this, "Added $login", Toast.LENGTH_SHORT).show()
                user_login.text.clear()
                user_email.text.clear()
                user_pass.text.clear()
                }

            }

        }

    }
