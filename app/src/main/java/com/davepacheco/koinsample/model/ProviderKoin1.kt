package com.davepacheco.koinsample.model

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import org.koin.androidx.viewmodel.ext.android.getViewModelByClass

import java.lang.IllegalArgumentException

class TileProviderKoin1(private val lifecycleOwner: LifecycleOwner): Provider{

    override fun provide(id: String, qualifier: String): TileViewModel {

        Log.i("KOIN", "About to get ViewModel for [$id] - named [$qualifier]")
        val viewModel: TileViewModel = when (id) {
            "A" -> {
                lifecycleOwner?.getViewModelByClass(
                    key = id,
                    name = qualifier,
                    clazz = TileAViewModel::class
                )
            }
            "B" -> {
                lifecycleOwner?.getViewModelByClass(
                    key = id,
                    name = qualifier,
                    clazz = TileBViewModel::class
                )
            }
            "AB" -> {
                lifecycleOwner?.getViewModelByClass(
                    key = id,
                    name = qualifier,
                    clazz = TileAViewModel::class
                )
            }
            "BA" -> {
                lifecycleOwner?.getViewModelByClass(
                    key = id,
                    name = qualifier,
                    clazz = TileBViewModel::class
                )
            }
            else -> throw IllegalArgumentException("Unsupported id $id")
        }
        viewModel.key = id
        Log.i("KOIN", "Got $viewModel")
        return viewModel
    }
}