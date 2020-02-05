package io.felipeandrade.marvelchars.data.characters

import characters.responses.ListAllCharactersResponse
import characters.responses.loadbyid.CharacterByIdResponse
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

    fun mapCharacterById(response: CharacterByIdResponse): MarvelCharacter? {
        response.data.results?.get(0)?.let {
            return MarvelCharacter(
                id = it.id,
                name = it.name,
                portraitUrl = "${it.thumbnail.path}.${it.thumbnail.extension}"
            )
        } ?: return null

    }
}