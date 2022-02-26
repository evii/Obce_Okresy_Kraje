package example.com.obce_okresy_kraje.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text

import androidx.compose.runtime.Composable

import com.squareup.moshi.Moshi
import example.com.obce_okresy_kraje.R
import example.com.obce_okresy_kraje.data.network.TownDistrictService
import example.com.obce_okresy_kraje.domain.models.TownItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : ComponentActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = job + Dispatchers.IO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "Obce, Okresy, Kraje")
        }

      //  setContentView(R.layout.activity_main)


        launch { getTowns() }
    }

    private suspend fun getTowns() {

        val moshi = Moshi.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl(TownDistrictService.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

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