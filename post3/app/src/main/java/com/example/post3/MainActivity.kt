package com.example.post3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.post3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSubmit.setOnClickListener {
            // Ambil nilai dari inputan
            val nama = binding.namaFull.text.toString()
            val username = binding.username.text.toString()
            val umur = binding.umur.text.toString()
            val email = binding.email.text.toString()

            // Ambil gender (radio button)
            val gender = when {
                binding.lk.isChecked -> "Laki-laki"
                binding.pr.isChecked -> "Perempuan"
                else -> "Tidak diketahui"
            }

            // Kirim data ke hasil.kt lewat Intent
            val intent = Intent(this, hasil::class.java).apply {
                putExtra("KET_NAMA", nama)
                putExtra("KET_USERNAME", username)
                putExtra("KET_UMUR", umur)
                putExtra("KET_EMAIL", email)
                putExtra("KET_GENDER", gender)
            }

            startActivity(intent)
        }
    }
}
