package com.example.combinecolors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.combinecolors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { CombineColor() }
    }
    private fun CombineColor() {
        val warna1 = binding.Warna1.text.toString()
        val warna2 = binding.Warna2.text.toString()

    if(warna1 == "Merah" && warna2 == "Kuning"|| warna1 == "Kuning" && warna2 == "Merah"){
        binding.Hasil.text = getString(R.string.Oren)
    }else if(warna1 == "Merah" && warna2 == "Hijau"|| warna1 == "Hijau" && warna2 == "Merah"){
        binding.Hasil.text = getString(R.string.Coklat)
    }else if(warna1 == "Merah" && warna2 == "Biru"|| warna1 == "Biru" && warna2 == "Merah"){
        binding.Hasil.text = getString(R.string.Ungu)
    }else if(warna1 == "Merah" && warna2 == "Ungu"|| warna1 == "Ungu" && warna2 == "Merah"){
        binding.Hasil.text = getString(R.string.Pink)
    }else if(warna1 == "Merah" && warna2 == "Merah"){
        binding.Hasil.text = getString(R.string.Merah)
    }



    else if(warna1 == "Kuning" && warna2 == "Hijau"|| warna1 == "Hijau" && warna2 == "Kuning"){
        binding.Hasil.text = getString(R.string.Hijau_muda)
    }else if(warna1 == "Kuning" && warna2 == "Biru"|| warna1 == "Biru" && warna2 == "Kuning"){
        binding.Hasil.text = getString(R.string.Hijau)
    }else if(warna1 == "Kuning" && warna2 == "Ungu"|| warna1 == "Ungu" && warna2 == "Kuning"){
        binding.Hasil.text = getString(R.string.Krem)
    }else if(warna1 == "Kuning" && warna2 == "Kuning"){
        binding.Hasil.text = getString(R.string.Kuning)
    }


    else if(warna1 == "Hijau" && warna2 == "Biru"|| warna1 == "Biru" && warna2 == "Hijau"){
        binding.Hasil.text = getString(R.string.Hijau_muda)
    }else if(warna1 == "Hijau" && warna2 == "Ungu"|| warna1 == "Ungu" && warna2 == "Hijau"){
        binding.Hasil.text = getString(R.string.Abu)
    }else if(warna1 == "Hijau" && warna2 == "Hijau"){
        binding.Hasil.text = getString(R.string.Hijau)
    }

    else if(warna1 == "Biru" && warna2 == "Ungu"|| warna1 == "Ungu" && warna2 == "Biru"){
        binding.Hasil.text = getString(R.string.Biru_tua)
    }else if(warna1 == "Biru" && warna2 == "Biru"){
        binding.Hasil.text = getString(R.string.Biru)
    }
    }
}