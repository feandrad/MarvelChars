package io.felipeandrade.marvelchars.usecases

import io.felipeandrade.marvelchars.data.CharacterRepository
import io.felipeandrade.marvelchars.domain.MarvelCharacter

class LoadCharacters(private val characterRepository: CharacterRepository) {
    suspend operator fun invoke(): List<MarvelCharacter> = characterRepository.loadAll()
}