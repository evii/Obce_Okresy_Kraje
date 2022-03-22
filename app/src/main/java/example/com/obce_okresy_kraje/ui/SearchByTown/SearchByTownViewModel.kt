package example.com.obce_okresy_kraje.ui.SearchByTown

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import example.com.obce_okresy_kraje.data.network.TownDistrictService
import example.com.obce_okresy_kraje.model.District
import example.com.obce_okresy_kraje.model.Town
import example.com.obce_okresy_kraje.model.TownItems
import example.com.obce_okresy_kraje.ui.BaseViewModel
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Response
import retrofit2.awaitResponse

class SearchByTownViewModel: BaseViewModel() {

    var searchTown = mutableStateOf("")
    var resultDistrict = MutableLiveData<String>()

    fun getDistrictForTown() {
        async {
            val towns = getTowns()
            Log.v("getDistrictForTown", "towns size: ${towns?.size}")
            val disctrictId = towns?.filter { it.townName.name == searchTown.value }?.get(0)?.district
            val districts = getDistricts()
            resultDistrict.postValue(districts?.filter { it.id == disctrictId }?.get(0)?.districtName?.name)
        }
    }

    fun onTownChange(searchTown: String) {
        this.searchTown.value = searchTown
    }

    private suspend fun getTowns(): List<Town>? {
        val service = retrofit.create(TownDistrictService::class.java)

        val townsCall: Call<TownItems> = service.getTowns()
        val response: Response<TownItems> = townsCall.awaitResponse()
        val towns: TownItems? = if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
        return towns?.towns
    }

    private suspend fun getDistricts(): List<District>? {
        val service = retrofit.create(TownDistrictService::class.java)

        val districtCall = service.getDistricts()
        val response = districtCall.awaitResponse()
        val districts = if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
        return districts?.districts
    }
}