package example.com.obce_okresy_kraje.data.network

import example.com.obce_okresy_kraje.domain.models.DistrictItems
import example.com.obce_okresy_kraje.domain.models.RegionItems
import example.com.obce_okresy_kraje.domain.models.TownItems
import retrofit2.Call
import retrofit2.http.GET

internal interface TownDistrictService {
    @GET("kraje.json")
    fun getRegions(): Call<RegionItems>

    @GET("okresy.json")
    fun getDistricts(): Call<DistrictItems>

    @GET("obce.json")
    fun getTowns(): Call<TownItems>

    companion object {
        const val BASE_URL = "https://data.mpsv.cz/od/soubory/ciselniky/"
    }
}