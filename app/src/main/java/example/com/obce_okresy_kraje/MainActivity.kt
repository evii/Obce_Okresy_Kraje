package example.com.obce_okresy_kraje

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.moshi.Moshi
import example.com.obce_okresy_kraje.model.TownItems
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
    }
}