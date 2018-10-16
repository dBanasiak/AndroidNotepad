package com.example.damian.loginapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context):SQLiteOpenHelper(context, dbname, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table passwords(id integer primary key autoincrement, password varchar(60))")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertPassword(password:String) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("password", password)

        db.insert("passwords", null,values)
        db.close()
    }

//    fun resetPassword() {
//        val db: SQLiteDatabase = writableDatabase
//        onCreate(db)
//    }

    fun passwordPresent(password: String): Boolean {
        val db = writableDatabase
        val query = "select * from passwords where password = $password"
        val cursor = db.rawQuery(query, null)
        if(cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

    companion object {
        internal val dbname = "userDB"
        internal val factory = null
        internal val version = 1
    }
}