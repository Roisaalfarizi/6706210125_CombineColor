package com.example.combinecolors

import com.example.combinecolors.model.Warna

class ColorLogic {
    fun combineColors(color1: String, color2: String): Warna {
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

    fun isValidColor(color: String): Boolean {
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

    fun getDisplayStringRes(warna: Warna): Int {
        return when (warna) {
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
    }
}
