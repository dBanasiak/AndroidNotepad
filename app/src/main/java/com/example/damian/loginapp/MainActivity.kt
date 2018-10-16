package com.example.damian.loginapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.set_password.*
import kotlinx.android.synthetic.main.user_login.*

class MainActivity : AppCompatActivity() {

    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = DatabaseHelper(this)

        login.setOnClickListener(){
            showLogin()
        }

        setpassword.setOnClickListener() {
            showSetpassword()
        }

        home.setOnClickListener() {
            showMain()
        }

        main.setOnClickListener() {
            showMain()
        }

        setbutton.setOnClickListener(){
             handler.insertPassword(setInput.text.toString())
        }

        checkButton.setOnClickListener {
            if(handler.passwordPresent(enterPasswordInput.text.toString())) {
                Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                showNotepad()
            }
            else
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }


    private fun showSetpassword() {
        setpassword_layout.visibility= View.VISIBLE
        login_layout.visibility = View.GONE
        main_page.visibility = View.GONE
        notepad_layout.visibility = View.GONE
    }

    private fun showLogin() {
        setpassword_layout.visibility= View.GONE
        login_layout.visibility = View.VISIBLE
        main_page.visibility = View.GONE
        notepad_layout.visibility = View.GONE
    }

    private fun showMain() {
        setpassword_layout.visibility= View.GONE
        login_layout.visibility = View.GONE
        main_page.visibility = View.VISIBLE
        notepad_layout.visibility = View.GONE
    }

    private fun showNotepad() {
        setpassword_layout.visibility= View.GONE
        login_layout.visibility = View.GONE
        main_page.visibility = View.GONE
        notepad_layout.visibility = View.VISIBLE
    }
}
