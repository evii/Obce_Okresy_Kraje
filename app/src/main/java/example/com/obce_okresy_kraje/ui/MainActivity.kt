package example.com.obce_okresy_kraje.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            SearchByTownLayout()
        }

        //  setContentView(R.layout.activity_main)

        launch { getTowns() }
    }

    @Preview
    @Composable
    private fun SearchByTownLayout() {
        Column(
            modifier = Modifier.padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchByTownTitle()
            Spacer(modifier = Modifier.height(40.dp))
            SearchByTownEditText()
            Spacer(modifier = Modifier.height(40.dp))
            SearchByTownResultDistrict()
            Spacer(modifier = Modifier.height(40.dp))
            SearchByTownResultRegion()
        }
    }

    @Composable
    private fun SearchByTownTitle() {
        Text(
            text = stringResource(id = R.string.district_for_town_title),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primaryVariant
        )
    }

    @Composable
    private fun SearchByTownEditText() {
        var town by rememberSaveable { mutableStateOf("") }
        TextField(
            value = town,
            onValueChange = { town = it },
            label = { Text(stringResource(id = R.string.district_for_town_edit_text_label)) })
    }

    @Composable
    private fun SearchByTownResultDistrict() {
        Text(
            text = "District",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primaryVariant
        )
    }

    @Composable
    private fun SearchByTownResultRegion() {
        Text(
            text = "Region",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primaryVariant
        )
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