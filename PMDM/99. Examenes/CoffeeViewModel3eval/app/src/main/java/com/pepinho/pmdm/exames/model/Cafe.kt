package com.pepinho.pmdm.exames.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cafe(
    @PrimaryKey(autoGenerate = true) val idCafe: Int = 0,
    val idCategoria: Int = 0,
    val nombre: String = "",
    val tipo: String = "",
    val calorias: Int = 0,
    val descripcion: String? = null,
    val foto: ByteArray? = null
) {
    override fun toString(): String {
        return "[$idCafe][$idCategoria] $nombre, $tipo de $calorias calorías: $descripcion (${foto?.contentToString()})"
    }
}

