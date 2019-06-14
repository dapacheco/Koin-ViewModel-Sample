package com.davepacheco.koinsample.model

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

interface TileViewModel {
    fun getLiveData() : LiveData<String>
    fun start()
    var key:String?
}

class TileAViewModel(val id: String) : TileViewModel, ViewModel() {

    override var key: String? = null
        set(value) {
            if (field == null && value != null) {
                field = value
            }
        }

    override fun toString(): String {
        return "TileAViewModel - $id - $key - ${hashCode()}"
    }

    private val data = MutableLiveData<String>().apply { value = "$key - Count 0" }

    override fun start() {
        for (i in 1..1000) {
            Handler().postDelayed({
                data.postValue("$key Count: $i")
            }, 100)
        }
    }

    override fun getLiveData(): LiveData<String> {
        return data
    }
}

class TileBViewModel(private val id: String) : TileViewModel, ViewModel() {

    override var key: String? = null
        set(value) {
            if (field == null && value != null) {
                field = value
            }
        }

    override fun toString(): String {
        return "TileBViewModel - $id - $key - ${hashCode()}"
    }


    private val data = MutableLiveData<String>().apply { value = "$key - Count 0" }

    override fun start() {
        for (i in 1..1000) {
            Handler().postDelayed({
                data.value = "$key - Count: $i"
            }, 200)
        }
    }

    override fun getLiveData(): LiveData<String> {
        return data
    }
}