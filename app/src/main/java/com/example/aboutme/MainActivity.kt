package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.data.MyName
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val myName : MyName = MyName("Abhay Phougat")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        /*setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_btn).setOnClickListener{
            populateNickName(it)
        }*/

        binding.doneBtn.setOnClickListener{
            populateNickName(it)
        }

    }

    private fun populateNickName(view : View){
        binding.apply {
            invalidateAll()
            doneBtn.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            myName?.nickname = "Hello "+ nicknameEdit.text.toString()
        }
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}