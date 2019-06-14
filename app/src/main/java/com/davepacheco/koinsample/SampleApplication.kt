package com.davepacheco.koinsample

import android.app.Application
import com.davepacheco.koinsample.model.TileAViewModel
import com.davepacheco.koinsample.model.TileBViewModel

// V2
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module


class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SampleApplication)
            modules(getAllModules())
            logger(AndroidLogger(Level.DEBUG))
        }
    }

    private fun getAllModules() : List<Module> {
        return listOf(appModule)
    }

    private val appModule = module {
        viewModel(named("TileA")) { TileAViewModel("A") }
        viewModel(named("TileB")) { TileBViewModel("B") }
    }
}

