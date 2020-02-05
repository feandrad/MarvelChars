package characters.responses

data class ListAllCharactersResponse(
    val copyright: String = "",
    val code: Int = 0,
    val data: Data,
    val attributionHTML: String = "",
    val attributionText: String = "",
    val etag: String = "",
    val status: String = ""
)