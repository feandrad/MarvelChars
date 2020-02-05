package io.felipeandrade.marvelchars.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.felipeandrade.marvelchars.domain.MarvelCharacter
import io.felipeandrade.marvelchars.usecases.LoadCharacterByIdUseCase
import kotlinx.coroutines.Dispatchers

class CharDetailsViewModel(
    private val loadCharacterById: LoadCharacterByIdUseCase
) : ViewModel() {

    var charId: Int = 0

    val characterData: LiveData<MarvelCharacter?> = liveData(Dispatchers.IO) {
        val retrievedData = loadCharacterById(charId)
        emit(retrievedData)
    }

}
