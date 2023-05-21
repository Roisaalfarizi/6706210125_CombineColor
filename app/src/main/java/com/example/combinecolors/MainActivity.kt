package com.example.combinecolors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.combinecolors.databinding.ActivityMainBinding

import com.example.combinecolors.model.Warna

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val colorLogic = ColorLogic()

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
        } else if (!colorLogic.isValidColor(warna1)) {
            showToast(R.string.outStock)
            return
        }

        if (TextUtils.isEmpty(warna2)) {
            showToast(R.string.Warna2_invalid)
            return
        } else if (TextUtils.isDigitsOnly(warna2)) {
            showToast(R.string.inputNumber)
            return
        } else if (!colorLogic.isValidColor(warna2)) {
            showToast(R.string.outStock)
            return
        }

        val result = colorLogic.combineColors(warna1, warna2)
        val displayStringRes = colorLogic.getDisplayStringRes(result)
        val displayString = getString(displayStringRes)
        binding.Hasil.text = displayString
    }

    private fun showToast(messageResId: Int) {
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG).show()
    }
}
