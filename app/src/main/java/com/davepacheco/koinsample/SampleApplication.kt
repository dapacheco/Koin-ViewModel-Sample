package com.davepacheco.koinsample

import android.app.Application
import com.davepacheco.koinsample.model.TileAViewModel
import com.davepacheco.koinsample.model.TileBViewModel

// V1
import org.koin.android.ext.android.startKoin
import org.koin.android.logger.AndroidLogger
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module



class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            androidContext = this,
            modules = getAllModules(),
            loadPropertiesFromFile = true,
            logger = AndroidLogger(true)
        )

    }

    private fun getAllModules() : List<Module> {
        return listOf(appModule)
    }

    private val appModule = module {
        viewModel(name = "TileA") { TileAViewModel("A") }
        viewModel(name = "TileB") { TileBViewModel("B") }
    }
}

