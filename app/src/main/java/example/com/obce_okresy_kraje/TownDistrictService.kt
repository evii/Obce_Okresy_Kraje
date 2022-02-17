package example.com.obce_okresy_kraje

import example.com.obce_okresy_kraje.model.District
import example.com.obce_okresy_kraje.model.Region
import example.com.obce_okresy_kraje.model.Town
import retrofit2.Call
import retrofit2.http.GET

private interface TownDistrictService {
    @GET("/kraje.json")
    fun getRegions(): Call<List<Region>>

    @GET("/okresy.json")
    fun getDistricts(): Call<List<District>>

    @GET("/obce.json")
    fun getTowns(): Call<List<Town>>

    companion object {
        const val BASE_URL = "https://data.mpsv.cz/od/soubory/ciselniky"
    }
}