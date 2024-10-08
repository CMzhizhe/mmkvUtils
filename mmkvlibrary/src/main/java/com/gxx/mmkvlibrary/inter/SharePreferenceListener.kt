package com.gxx.mmkvlibrary.inter

interface SharePreferenceListener {

    fun putString(var1: String, var2: String)

    fun putInt(var1: String, var2: Int)

    fun putBoolean(var1: String, var2: Boolean)

    fun putByte(var1: String, var2: ByteArray)

    fun putShort(var1: String, var2: Short)

    fun putLong(var1: String, var2: Long)

    fun putFloat(var1: String, var2: Float)

    fun putDouble(var1: String, var2: Double)

    fun getString(var1: String, defaultValue: String): String

    fun getInt(var1: String, defaultValue: Int): Int

    fun getBoolean(var1: String, defaultValue: Boolean): Boolean

    fun getByte(var1: String, defaultValue: ByteArray): ByteArray

    fun getShort(var1: String, defaultValue: Short): Short

    fun getLong(var1: String, defaultValue: Long): Long

    fun getFloat(var1: String, defaultValue: Float): Float

    fun getDouble(var1: String, defaultValue: Double): Double

    fun remove(var1: String)

    fun remove(vararg var1: String)

    fun clear()


   suspend fun writeFileString(fileName: String, var2: String)

   suspend fun getFileString(fileName: String):String
}