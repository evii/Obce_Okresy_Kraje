package example.com.obce_okresy_kraje.ui

import androidx.lifecycle.ViewModel
import com.squareup.moshi.Moshi
import example.com.obce_okresy_kraje.data.network.TownDistrictService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class BaseViewModel: ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext = job + Dispatchers.IO

    val moshi = Moshi.Builder().build()
    val retrofit = Retrofit.Builder()
        .baseUrl(TownDistrictService.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}