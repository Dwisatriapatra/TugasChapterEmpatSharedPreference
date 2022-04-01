package com.example.tugaschapterempatsharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugaschapterempatsharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var sharedPreference : SharedPreferences
    //login activity act as login screen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(getSharedPreferences("Memory", Context.MODE_PRIVATE).contains("USERNAME") &&
            getSharedPreferences("Memory", Context.MODE_PRIVATE).contains("PASSWORD")){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }else{
            sharedPreference = getSharedPreferences("Memory", Context.MODE_PRIVATE)
            loginAuth()
        }
    }
    fun loginAuth(){
        binding.buttonLogin.setOnClickListener {
            val username = binding.inputanUsername.text.toString()
            val password = binding.inputanPassword.text.toString()

            if(username == "patra" && password == "12345"){
                val sf = sharedPreference.edit()
                sf.putString("USERNAME", username)
                sf.putString("PASSWORD", password)
                sf.apply()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Your username/password wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}