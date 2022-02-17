package example.com.obce_okresy_kraje.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Town(
    val id: String,
    @Json(name = "kod") val townCode: String,
    @Json(name = "nazev") val townName: Name,
    @Json(name = "okres") val district: String
)

@JsonClass(generateAdapter = true)
data class TownItems(
    @Json(name = "polozky") val towns: List<Town>
)
