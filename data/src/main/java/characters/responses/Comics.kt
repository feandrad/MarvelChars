package characters.responses

data class Comics(val collectionURI: String = "",
                  val available: Int = 0,
                  val returned: Int = 0,
                  val items: List<ItemsItem>?)