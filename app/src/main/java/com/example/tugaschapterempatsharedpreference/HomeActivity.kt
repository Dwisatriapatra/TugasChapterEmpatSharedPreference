package com.example.tugaschapterempatsharedpreference

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.tugaschapterempatsharedpreference.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private lateinit var sharedPreference : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreference = getSharedPreferences("Memory", Context.MODE_PRIVATE)
        val getUsername = sharedPreference.getString("USERNAME", "")
        binding.result.text = "Hello, $getUsername"

        binding.buttonLogout.setOnClickListener {
            val buildAlertDialog = AlertDialog.Builder(this)
            buildAlertDialog.setTitle("LOGOUT")
            buildAlertDialog.setMessage("Yakin logout?")
            val dialog = buildAlertDialog.create()
            buildAlertDialog.setPositiveButton("YA"){ dialogInterface: DialogInterface, i: Int ->
                logout()
            }.setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                dialog.dismiss()
            }
            buildAlertDialog.show()
        }
    }

    private fun logout() {
        val logoutProcess = sharedPreference.edit()
        logoutProcess.clear()
        logoutProcess.apply()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}