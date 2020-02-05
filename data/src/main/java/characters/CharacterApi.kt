package io.felipeandrade.marvelchars.data.characters

import characters.responses.ListAllCharactersResponse
import characters.responses.loadbyid.CharacterByIdResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("/v1/public/characters")
    suspend fun loadAllCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): ListAllCharactersResponse

    @GET("/v1/public/characters")
    suspend fun loadCharacterById(
        @Query("ts") ts: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("id") charId: Int
    ): CharacterByIdResponse

}
