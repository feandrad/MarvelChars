package io.felipeandrade.marvelchars.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.felipeandrade.marvelchars.domain.MarvelCharacter
import io.felipeandrade.marvelchars.usecases.LoadCharactersUseCase
import kotlinx.coroutines.Dispatchers

class CharSelectionViewModel(val loadCharacters: LoadCharactersUseCase) : ViewModel() {


    val characterList: LiveData<List<MarvelCharacter>> = liveData(Dispatchers.IO) {
        val retrievedData = loadCharacters()
        emit(retrievedData)
    }

    val selectedCharacter = MutableLiveData<MarvelCharacter>()


    fun characterClicked(character: MarvelCharacter) {
        selectedCharacter.postValue(character)
    }

}
