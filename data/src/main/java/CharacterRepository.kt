package io.felipeandrade.marvelchars.data

import io.felipeandrade.marvelchars.data.characters.CharacterApi
import io.felipeandrade.marvelchars.domain.MarvelCharacter

class CharacterRepository(val characterApi: CharacterApi) {

    suspend fun loadAll(): List<MarvelCharacter> = characterApi.loadAllCharacters()

    suspend fun loadCharacter(charId: Int): MarvelCharacter = characterApi.loadCharacterById(charId)


}