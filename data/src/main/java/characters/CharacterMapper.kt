package io.felipeandrade.marvelchars.data.characters

import characters.responses.ListAllCharactersResponse
import io.felipeandrade.marvelchars.domain.MarvelCharacter

class CharacterMapper {
    fun mapAllCharacters(response: ListAllCharactersResponse): List<MarvelCharacter> {
        val result: MutableList<MarvelCharacter> = mutableListOf()

        response.data.results?.let {
            for (item in it) {
                result.add(
                    MarvelCharacter(
                        id = item.id,
                        name = item.name,
                        portraitUrl = "${item.thumbnail.path}.${item.thumbnail.extension}"
                    )
                )
            }
        }

        return result
    }
}