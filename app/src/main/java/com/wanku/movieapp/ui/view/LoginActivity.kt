package com.wanku.movieapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wanku.movieapp.R
import com.wanku.movieapp.databinding.ActivityLogin2Binding

class LoginActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityLogin2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = binding.etUser
        val pass = binding.etPass
        val msj = binding.tvError
        val btn = binding.button

        btn.setOnClickListener {
            val userlogin=user.text.toString()
            val passlogin=pass.text.toString()
            if((userlogin == "Admin")and(passlogin == "*123")){
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                binding.etUser.text.clear()
                binding.etPass.text.clear()
                msj.text=getString(R.string.msj_error)
            }
        }

    }
}