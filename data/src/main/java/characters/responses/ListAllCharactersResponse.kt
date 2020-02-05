package characters.responses

data class ListAllCharactersResponse(
    val copyright: String = "",
    val code: Int = 0,
    val data: ListAllCharactersData,
    val attributionHTML: String = "",
    val attributionText: String = "",
    val etag: String = "",
    val status: String = ""
)

data class ListAllCharactersData(val total: Int = 0,
                                 val offset: Int = 0,
                                 val limit: Int = 0,
                                 val count: Int = 0,
                                 val results: List<ResultsItem>?)