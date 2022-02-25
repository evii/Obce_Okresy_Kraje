package example.com.obce_okresy_kraje.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class District(
    val id: String,
    @Json(name = "kod") val districtCode: String,
    @Json(name = "nazev") val districtName: Name,
    @Json(name = "kraj") val region: String
)

@JsonClass(generateAdapter = true)
data class DistrictItems(
    @Json(name = "polozky") val districts: List<District>
)
