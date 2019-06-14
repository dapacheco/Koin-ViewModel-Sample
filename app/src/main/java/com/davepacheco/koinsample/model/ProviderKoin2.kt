package com.davepacheco.koinsample.model

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.IllegalArgumentException

class TileProviderKoin2(private val lifecycleOwner: LifecycleOwner) : Provider {

    override fun provide(id: String, qualifier: String): TileViewModel {
        Log.i("KOIN", "About to get ViewModel for [$id] - named [$qualifier]")
        val viewModel: TileViewModel = when (id) {
            "A" -> {
                lifecycleOwner.getViewModel(clazz = TileAViewModel::class,
                    qualifier = named(qualifier)
                )
            }
            "B" -> {
                lifecycleOwner.getViewModel(clazz = TileBViewModel::class,
                    qualifier = named(qualifier)
                )
            }
            "AB" -> {
                lifecycleOwner.getViewModel(clazz = TileAViewModel::class,
                    qualifier = named(qualifier)
                )

            }
            "BA" -> {
                lifecycleOwner.getViewModel(clazz = TileBViewModel::class,
                    qualifier = named(qualifier)
                )
            }
            else -> throw IllegalArgumentException("Unsupported id $id")
        }
        viewModel.key = id
        Log.i("KOIN", "Got $viewModel")
        return viewModel
    }
}