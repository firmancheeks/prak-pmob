package com.example.post3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.post3.databinding.ActivityHasilBinding


class hasil : AppCompatActivity() {

    private lateinit var binding: ActivityHasilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val nama = intent.getStringExtra("KET_NAMA")
        val username = intent.getStringExtra("KET_USERNAME")
        val umur = intent.getStringExtra("KET_UMUR")
        val email = intent.getStringExtra("KET_EMAIL")
        val gender = intent.getStringExtra("KET_GENDER")

        // Tampilkan di TextView
        binding.iniNama.text = "Full Name: $nama"
        binding.iniUsername.text = "Username: $username"
        binding.iniUmur.text = "Age: $umur"
        binding.iniEmail.text = "Email: $email"
        binding.textView19.text = "Gender: $gender"
    }
}
