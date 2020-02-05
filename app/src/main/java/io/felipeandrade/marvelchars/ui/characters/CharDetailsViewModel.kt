package io.felipeandrade.marvelchars.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.felipeandrade.marvelchars.domain.MarvelCharacter

class CharDetailsViewModel : ViewModel() {

    val characterData= MutableLiveData<MarvelCharacter>()
}
