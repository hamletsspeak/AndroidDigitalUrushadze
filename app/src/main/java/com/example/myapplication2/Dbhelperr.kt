package com.example.myapplication2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class Dbhelperr (val context:Context, factory:SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, "App",factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INTEGER PRIMARY KEY, AUTO_INCREMENT DEFAULT NULL, login TEXT, email TEXT, pass TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }
fun addUser(user:User) {
    val values = ContentValues()
    values.put("login", user.login)
    values.put("email", user.email)
    values.put("pass", user.pass)
    val db = this.writableDatabase
    db.insert("users", null, values)
    db.close()
}
fun getUser(login: String, pass: String): Boolean{
    val db=this.readableDatabase
    val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND pass = '$pass'", null)
    return result.moveToFirst()
}
}