package io.felipeandrade.marvelchars.data.characters

import io.felipeandrade.marvelchars.domain.MarvelCharacter
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {

    @GET("/v1/public/characters")
    suspend fun loadAllCharacters(): List<MarvelCharacter>

    @GET("/v1/public/characters/{id}")
    suspend fun loadCharacterById(@Path("id") charId: Int): MarvelCharacter

}
