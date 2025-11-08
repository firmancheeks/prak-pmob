package com.example.lapraknextnext

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Dao
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dbBarang: DatabaseBarang
    private lateinit var barangDao: BarangDao
    private lateinit var appExecutors: Executors

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding
        setContentView(binding.root)

        appExecutors = AppExecutor()
        dbBarang = DatabaseBarang.getDatabase(applicationContext)
        barangDao = dbBarang.barangDao()

        binding.apply{
            fabAdd.setOnClickListener{
                appExecutors.diskIO.execute{
                    val barangTitles = listOf("Meja", "Semen", "Triplek", "Pasir")
                    val jenisBarang = listOf("Perabotan", "Material", "Material", "Material")
                    val hargaBarang = listOf(50000, 48000, 15000, 68000)
                    for (i in 1..4){
                        val newBarang = Barang(i, barangTitles[i-1], jenisBarang[i-1], hargaBarang[i-1])
                        barangDao.insert(newBarang)
                    }
                }
            }
        }
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}