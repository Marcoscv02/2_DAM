package com.pepinho.pmdm.exames.repository

import android.content.Context
import androidx.room.Room
import com.pepinho.pmdm.exames.database.CoffeeDatabase
import com.pepinho.pmdm.exames.model.Cafe

private const val NOMBRE_BASE_DATOS = "starbuckscaffee.db"

class CafeRepository private constructor(context: Context) {
    private val baseDeDatos: CoffeeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            CoffeeDatabase::class.java,
            NOMBRE_BASE_DATOS
        )
        .createFromAsset(NOMBRE_BASE_DATOS)
        .build()

    companion object {
        @Volatile
        private var INSTANCE: CafeRepository? = null

        //        fun getInstance(context: Context) : CafeRepository{
//            if (INSTANCE == null) {
//                synchronized(this) {
//                    if (INSTANCE == null)
//                        INSTANCE = CafeRepository(context.applicationContext)
//                }
//            }
//            return INSTANCE!!
//        }
        fun getInstance(context: Context): CafeRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: CafeRepository(context.applicationContext).also { INSTANCE = it }
            }

        fun get(): CafeRepository {
            return INSTANCE
                ?: throw IllegalStateException("Debes inicializar el repositorio de cafés")
        }
    }

    suspend fun getCafes() = baseDeDatos.cafeDao().getAll()
    suspend fun getCafesConCategoria() = baseDeDatos.cafeDao().getCafesConCategoria()
    suspend fun insertCafe(cafe: Cafe) = baseDeDatos.cafeDao().insert(cafe)
    suspend fun getCafeById(id: Int) = baseDeDatos.cafeDao().getCafeById(id)
    suspend fun getCafeRandom() = baseDeDatos.cafeDao().getRandom()
    suspend fun findCafeByNombre(nombre: String) = baseDeDatos.cafeDao().findByNome(nombre)
    suspend fun deleteCafe(cafe: Cafe) = baseDeDatos.cafeDao().delete(cafe)
    suspend fun getCafeConCategoriaById(id: Int) =
        baseDeDatos.cafeDao().getCafeConCategoriaById(id)

    suspend fun getCafeConCategoriaRandom() = baseDeDatos.cafeDao().getRandomCafeConCategoria()
    suspend fun getCategorias() = baseDeDatos.categoriaDao().getAll()

}