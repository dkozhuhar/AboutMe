package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Instance of MyName data class.
        val myName = MyName("Aleks Haecky")
        val binding: com.example.android.aboutme.databinding.ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val nickName = binding.nicknameText
        val editNickName = binding.editText
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            nickName.text = editNickName.text
            it.visibility = View.GONE
            editNickName.visibility = View.GONE
            nickName.visibility = View.VISIBLE
            // Hide the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}

data class MyName(var name: String = "", var nickname: String = "")