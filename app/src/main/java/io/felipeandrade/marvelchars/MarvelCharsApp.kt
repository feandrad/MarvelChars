package io.felipeandrade.marvelchars

import android.app.Application
import io.felipeandrade.marvelchars.di.characterModule
import io.felipeandrade.marvelchars.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MarvelCharsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDependencyInjection()
    }

    private fun initDependencyInjection() {
        startKoin {
            androidLogger()
            androidContext(this@MarvelCharsApp)
            modules(
                listOf(
                    coreModule,
                    characterModule
                )
            )
        }
    }
}