package example.com.obce_okresy_kraje.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Region(
    val id: String,
    @Json(name = "kod") val regionCode: String,
    @Json(name = "nazev") val regionName: Name,
)

@JsonClass(generateAdapter = true)
data class RegionItems(
    @Json(name = "polozky") val region: List<Region>
)
