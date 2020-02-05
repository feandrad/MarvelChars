package io.felipeandrade.marvelchars.data

import io.felipeandrade.marvelchars.data.characters.CharacterApi
import io.felipeandrade.marvelchars.data.characters.CharacterMapper
import io.felipeandrade.marvelchars.domain.MarvelCharacter
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class CharacterRepository(
    private val characterApi: CharacterApi,
    private val characterMapper: CharacterMapper
) {

    suspend fun loadAll(): List<MarvelCharacter> {
        val ts = System.currentTimeMillis().toString()

        val allCharactersResponse = characterApi.loadAllCharacters(
            ts, BuildConfig.PUBLIC_API_KEY, getMd5(ts)
        )

        return characterMapper.mapAllCharacters(allCharactersResponse)
    }

    suspend fun loadCharacter(charId: Int): MarvelCharacter {
        val ts = System.currentTimeMillis().toString()
        return characterApi.loadCharacterById(
            ts, BuildConfig.PUBLIC_API_KEY, getMd5(ts), charId
        )
    }

    private fun getMd5(ts: String): String {
        try {

            val md = MessageDigest.getInstance("MD5")

            val messageDigest = md.digest(
                ts.toByteArray()
                        + BuildConfig.PRIVATE_API_KEY.toByteArray()
                        + BuildConfig.PUBLIC_API_KEY.toByteArray()
            )

            val no = BigInteger(1, messageDigest)

            var hashtext = no.toString(16)
            while (hashtext.length < 32) {
                hashtext = "0$hashtext"
            }
            return hashtext
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }

//    override fun getCharacter(callback: OnGetMarvelCallback) {
//        val ts = System.currentTimeMillis().toString()
//        var hash = getMd5(ts)
//
//        service.getCharacters(ts, SyncStateContract.Constants.Keys.PUBLIC_KEY, hash)
//            .enqueue(object : Callback<ReturnData>{
//                override fun onResponse(call: Call<ReturnData>, response: Response<ReturnData>) {
//
//                    if (response.isSuccessful){
//                        if (response.body() != null){
//                            heroesData.postValue(response.body())
//                            callback.onSuccess(response.body()!!)
//                        } else {
//                            callback.onError()
//                            Log.e("Response", " response null")
//                        }
//
//                    } else {
//                        callback.onError()
//                        Log.e("Response", response.raw().networkResponse().toString())
//                    }
//
//                }
//
//                override fun onFailure(call: Call<ReturnData>, t: Throwable) {
//                    callback.onError()
//                    t.printStackTrace()
//                    Log.e("Response", javaClass.simpleName + " not response 2 " + t)
//                }
//            })
//    }


}