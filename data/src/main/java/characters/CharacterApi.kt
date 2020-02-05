package io.felipeandrade.marvelchars.data.characters

import io.felipeandrade.marvelchars.domain.MarvelCharacter
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("/v1/public/characters")
    suspend fun loadAllCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): List<MarvelCharacter>

    @GET("/v1/public/characters/")
    suspend fun loadCharacterById(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("id") charId: Int
    ): MarvelCharacter

}
