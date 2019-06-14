package com.davepacheco.koinsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.davepacheco.koinsample.model.TileProviderKoin2
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.textViewA
import kotlinx.android.synthetic.main.activity_main.textViewAB
import kotlinx.android.synthetic.main.activity_main.textViewB
import kotlinx.android.synthetic.main.activity_main.textViewBA

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = TileProviderKoin2(this as LifecycleOwner)
        button.setOnClickListener {
            provider.provide("A", "TileA").start()
            provider.provide("AB", "TileA").start()
            provider.provide("B", "TileB").start()
            provider.provide("BA", "TileB").start()
            button.isEnabled = false
        }

        val tileAObserver = Observer<String> { value ->
            textViewA.text = value
        }

        val tileBObserver = Observer<String> { value ->
            textViewB.text = value
        }

        val tileABObserver = Observer<String> { value ->
            textViewAB.text = value
        }

        val tileBAObserver = Observer<String> { value ->
            textViewBA.text = value
        }

        provider.provide("A", "TileA").getLiveData().observe(this, tileAObserver)
        provider.provide("AB", "TileA").getLiveData().observe(this, tileABObserver)
        provider.provide("B", "TileB").getLiveData().observe(this, tileBObserver)
        provider.provide("BA", "TileB").getLiveData().observe(this, tileBAObserver)
    }

}
