package characters.responses.loadbyid

data class Series(val collectionURI: String = "",
                  val available: Int = 0,
                  val returned: Int = 0,
                  val items: List<ItemsItem>?)


data class Events(val collectionURI: String = "",
                  val available: Int = 0,
                  val returned: Int = 0)


data class ResultsItem(val thumbnail: Thumbnail,
                       val urls: List<UrlsItem>?,
                       val stories: Stories,
                       val series: Series,
                       val comics: Comics,
                       val name: String = "",
                       val description: String = "",
                       val modified: String = "",
                       val id: Int = 0,
                       val resourceURI: String = "",
                       val events: Events)


data class CharacterByIdResponse(val copyright: String = "",
                                 val code: Int = 0,
                                 val data: Data,
                                 val attributionHTML: String = "",
                                 val attributionText: String = "",
                                 val etag: String = "",
                                 val status: String = "")


data class UrlsItem(val type: String = "",
                    val url: String = "")


data class ItemsItem(val name: String = "",
                     val resourceURI: String = "")


data class Data(val total: Int = 0,
                val offset: Int = 0,
                val limit: Int = 0,
                val count: Int = 0,
                val results: List<ResultsItem>?)


data class Stories(val collectionURI: String = "",
                   val available: Int = 0,
                   val returned: Int = 0,
                   val items: List<ItemsItem>?)


data class Thumbnail(val path: String = "",
                     val extension: String = "")


data class Comics(val collectionURI: String = "",
                  val available: Int = 0,
                  val returned: Int = 0,
                  val items: List<ItemsItem>?)


