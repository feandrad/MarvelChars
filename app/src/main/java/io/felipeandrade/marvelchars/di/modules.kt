package io.felipeandrade.marvelchars.di

import io.felipeandrade.marvelchars.data.CharacterRepository
import io.felipeandrade.marvelchars.ui.characters.CharSelectionActivity
import io.felipeandrade.marvelchars.ui.characters.CharSelectionAdapter
import io.felipeandrade.marvelchars.ui.characters.CharSelectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val coreModule = module(override = true) {
    factory { CharacterRepository(get()) }
}

val characterModule = module(override = true) {
    factory { CharSelectionAdapter() }
    viewModel { CharSelectionViewModel(get()) }

//    factory { BrowseAdapter() }
//    factory { GetBufferoos(get(), get(), get()) }
//    viewModel { BrowseBufferoosViewModel(get()) }
}



