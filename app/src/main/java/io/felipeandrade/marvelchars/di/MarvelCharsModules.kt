package io.felipeandrade.marvelchars.di

import io.felipeandrade.marvelchars.data.CharacterRepository
import io.felipeandrade.marvelchars.ui.characters.CharSearchActivity
import io.felipeandrade.marvelchars.ui.characters.CharSearchViewModel
import org.koin.dsl.module


val coreModule = module(override = true) {
    factory { CharacterRepository(get()) }
}

val characterModule = module(override = true) {
    factory { (view: CharSearchActivity) -> CharSearchViewModel(view) }
}



