package com.example.combinecolors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.combinecolors.databinding.ActivityMainBinding
import com.example.combinecolors.model.Hasil
import com.example.combinecolors.model.Warna

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { combineColor() }
    }

    private fun combineColor() {
        val warna1 = binding.Warna1.text.toString()
        val warna2 = binding.Warna2.text.toString()

        if (TextUtils.isEmpty(warna1)) {
            showToast(R.string.Warna1_invalid)
            return
        } else if (TextUtils.isDigitsOnly(warna1)) {
            showToast(R.string.inputNumber)
            return
        } else if (!isValidColor(warna1)) {
            showToast(R.string.outStock)
            return
        }

        if (TextUtils.isEmpty(warna2)) {
            showToast(R.string.Warna2_invalid)
            return
        } else if (TextUtils.isDigitsOnly(warna2)) {
            showToast(R.string.inputNumber)
            return
        } else if (!isValidColor(warna2)) {
            showToast(R.string.outStock)
            return
        }
        val result = combineColors(warna1, warna2)
        setDisplayResources(result)

    }

    private fun showToast(messageResId: Int) {
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG).show()
    }

    private fun isValidColor(color: String): Boolean {
        val validColors = listOf(
            "Merah",
            "Kuning",
            "Hijau",
            "Ungu",
            "Biru",
            "merah",
            "kuning",
            "hijau",
            "ungu",
            "biru"
        )
        return validColors.contains(color)
    }

    private fun combineColors(color1: String, color2: String): Warna {
        return when {
            (color1 == "Merah" && color2 == "Kuning") || (color1 == "Kuning" && color2 == "Merah") -> Warna.Oren
            (color1 == "Merah" && color2 == "Hijau") || (color1 == "Hijau" && color2 == "Merah") -> Warna.Coklat
            (color1 == "Merah" && color2 == "Biru") || (color1 == "Biru" && color2 == "Merah") -> Warna.Ungu
            (color1 == "Merah" && color2 == "Ungu") || (color1 == "Ungu" && color2 == "Merah") -> Warna.Pink
            color1 == "Merah" && color2 == "Merah" -> Warna.Merah
            (color1 == "Kuning" && color2 == "Hijau") || (color1 == "Hijau" && color2 == "Kuning") -> Warna.Hijau_Muda
            (color1 == "Kuning" && color2 == "Biru") || (color1 == "Biru" && color2 == "Kuning") -> Warna.Hijau
            (color1 == "Kuning" && color2 == "Ungu") || (color1 == "Ungu" && color2 == "Kuning") -> Warna.Krem
            color1 == "Kuning" && color2 == "Kuning" -> Warna.Kuning
            (color1 == "Hijau" && color2 == "Biru") || (color1 == "Biru" && color2 == "Hijau") -> Warna.Hijau_Muda
            (color1 == "Hijau" && color2 == "Ungu") || (color1 == "Ungu" && color2 == "Hijau") -> Warna.Abu
            color1 == "Hijau" && color2 == "Hijau" -> Warna.Hijau
            (color1 == "Biru" && color2 == "Ungu") || (color1 == "Ungu" && color2 == "Biru") -> Warna.Biru_tua
            color1 == "Biru" && color2 == "Biru" -> Warna.Biru
            color1 == "Ungu" && color2 == "Ungu" -> Warna.Ungu
            else -> throw IllegalArgumentException("Invalid color combination")
        }
    }

    private fun setDisplayResources(warna: Warna) {
        val displayStringRes = when (warna) {
            Warna.Oren -> R.string.oren
            Warna.Coklat -> R.string.coklat
            Warna.Ungu -> R.string.ungu
            Warna.Pink -> R.string.pink
            Warna.Merah -> R.string.merah
            Warna.Hijau_Muda -> R.string.hijau_muda
            Warna.Hijau -> R.string.hijau
            Warna.Krem -> R.string.krem
            Warna.Kuning -> R.string.kuning
            Warna.Abu -> R.string.abu
            Warna.Biru_tua -> R.string.biru_tua
            Warna.Biru -> R.string.biru
            Warna.Ungu -> R.string.ungu
        }
        val displayString = getString(displayStringRes)
        binding.Hasil.text = displayString
    }
}