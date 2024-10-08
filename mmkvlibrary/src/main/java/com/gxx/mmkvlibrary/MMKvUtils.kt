package com.gxx.mmkvlibrary

import android.content.Context
import com.gxx.mmkvlibrary.inter.SharePreferenceListener
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.Reader


object MMKvUtils : SharePreferenceListener {
   private val MMKV_DEFAULT_NAME = "mmSharePreference"

    private var mmkv:MMKV? = null;
    private var writeFilePath = "";


    class Builder{
       private var context:Context? = null;
       private var mmkvName:String? = null;

        fun getContext():Context{
            return context!!
        }

        fun getMMkvName():String?{
            return mmkvName
        }

        fun setContext(context: Context): Builder {
            this.context = context;
            return this;
        }

        fun setMMkvName(mmkvName:String): Builder {
            this.mmkvName = mmkvName;
            return this;
        }

        fun build() {
            if(context == null){
                throw IllegalStateException("未设置 context")
            }

            init(this)
        }
    }


    private fun init(builder: Builder){
        val path = builder.getContext().filesDir.absolutePath + File.separator + "mmkv"
        writeFilePath = builder.getContext().filesDir.absolutePath + File.separator + "mmkv" + File.separator + "files"
        MMKV.initialize(builder.getContext(),path)
        mmkv = MMKV.mmkvWithID(if(builder.getMMkvName().isNullOrEmpty()) MMKV_DEFAULT_NAME else builder.getMMkvName(),MMKV.MULTI_PROCESS_MODE)
    }


    override fun putString(var1: String, var2: String) {
        mmkv?.encode(var1,var2)
    }

    override fun putInt(var1: String, var2: Int) {
       mmkv?.encode(var1,var2)
    }

    override fun putBoolean(var1: String, var2: Boolean) {
        mmkv?.encode(var1,var2)
    }

    override fun putByte(var1: String, var2: ByteArray) {
        mmkv?.encode(var1,var2)
    }

    override fun putShort(var1: String, var2: Short) {
        this.putString(var1,var2.toString())
    }

    override fun putLong(var1: String, var2: Long) {
        mmkv?.encode(var1,var2)
    }

    override fun putFloat(var1: String, var2: Float) {
        mmkv?.encode(var1,var2)
    }

    override fun putDouble(var1: String, var2: Double) {
        mmkv?.encode(var1,var2)
    }

    override fun getString(var1: String, defaultValue: String): String {
       return mmkv?.decodeString(var1,defaultValue) ?: defaultValue
    }

    override fun getInt(var1: String, defaultValue: Int): Int {
        return mmkv?.decodeInt(var1, defaultValue) ?: defaultValue
    }

    override fun getBoolean(var1: String, defaultValue: Boolean): Boolean {
        return mmkv?.decodeBool(var1, defaultValue) ?: defaultValue
    }

    override fun getByte(var1: String, defaultValue: ByteArray): ByteArray {
        return mmkv?.decodeBytes(var1, defaultValue) ?: defaultValue
    }

    override fun getShort(var1: String, defaultValue: Short): Short {
       return this.getString(var1,defaultValue.toString()).toShort()
    }

    override fun getLong(var1: String, defaultValue: Long): Long {
        return mmkv?.decodeLong(var1,defaultValue) ?: defaultValue
    }

    override fun getFloat(var1: String, defaultValue: Float): Float {
        return mmkv?.decodeFloat(var1,defaultValue) ?: defaultValue
    }

    override fun getDouble(var1: String, defaultValue: Double): Double {
        return mmkv?.decodeDouble(var1,defaultValue) ?: defaultValue
    }

    override fun remove(var1: String) {
        mmkv?.remove(var1)
    }

    override fun remove(vararg var1: String) {
        for (s in var1) {
            remove(s)
        }
    }

    override fun clear() {
       mmkv?.clearAll()
    }


    override suspend fun writeFileString(fileName: String, var2: String) {
          val parentFile = File(writeFilePath)
          if(!parentFile.exists()){
              parentFile.mkdirs()
          }

          val file = File(parentFile.absolutePath,"${fileName}.txt")
          if(file.exists()){
              file.delete()
          }

          withContext(Dispatchers.IO) {
              if(!file.exists()){
                  file.createNewFile()
              }
              val fos = FileOutputStream(file)
              val writer = OutputStreamWriter(fos,"UTF-8")
              writer.write(var2)
              writer.flush()
              writer.close()
          }
    }

    override suspend fun getFileString(fileName: String):String {
        var inputStream: InputStream? = null
        var reader: Reader? = null
        var bufferedReader: BufferedReader? = null
        val result = StringBuilder()

        val file = File(writeFilePath, "${fileName}.txt")
        if(!file.exists()){
            return ""
        }

        withContext(Dispatchers.IO){
            try {
                val targetFile = File(writeFilePath, "${fileName}.txt")
                inputStream = FileInputStream(targetFile)
                reader = InputStreamReader(inputStream)
                bufferedReader = BufferedReader(reader)

                var temp: String?
                while ((bufferedReader!!.readLine().also { temp = it }) != null) {
                    result.append(temp)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (reader != null) {
                    try {
                        reader!!.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream!!.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader!!.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }

        return  result.toString()
    }

}