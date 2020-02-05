package io.felipeandrade.marvelchars.usecases

import io.felipeandrade.marvelchars.data.CharacterRepository
import io.felipeandrade.marvelchars.domain.MarvelCharacter

class LoadCharacterById( private val characterRepository: CharacterRepository) {
    suspend operator fun invoke(charId: Int): MarvelCharacter = characterRepository.loadCharacter(charId)
}