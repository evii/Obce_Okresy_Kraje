package example.com.obce_okresy_kraje.ui.SearchByTown

import android.util.Log
import androidx.lifecycle.ViewModel
import com.squareup.moshi.Moshi
import example.com.obce_okresy_kraje.data.network.TownDistrictService
import example.com.obce_okresy_kraje.model.TownItems
import example.com.obce_okresy_kraje.ui.BaseViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.moshi.MoshiConverterFactory

class SearchByTownViewModel: BaseViewModel() {

    fun launchTowns() {
        launch { getTowns() }
    }

    private suspend fun getTowns() {

        val service = retrofit.create(TownDistrictService::class.java)

        val townsCall: Call<TownItems> = service.getTowns()
        val response: Response<TownItems> = townsCall.awaitResponse()
        val towns: TownItems? = if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
        val first = towns?.towns?.get(0)?.townName?.name
        Log.v("call", "firstTown: $first")
    }

}