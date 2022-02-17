package example.com.obce_okresy_kraje.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Name(
    @Json(name = "cs") val name: String
)