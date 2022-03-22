package example.com.obce_okresy_kraje.ui.SearchByTown

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import example.com.obce_okresy_kraje.R
import example.com.obce_okresy_kraje.ui.components.FindButton
import example.com.obce_okresy_kraje.ui.components.ResultText
import example.com.obce_okresy_kraje.ui.components.TitleText
import example.com.obce_okresy_kraje.ui.components.VerticalSpace

@Preview
@Composable
fun SearchByTownScreen() {
    val searchByTownViewModel: SearchByTownViewModel = viewModel()
    val resultDistrict by searchByTownViewModel.resultDistrict.observeAsState()
    Column(
        modifier = Modifier.padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleText(R.string.district_for_town_title)
        VerticalSpace()
        val town = searchByTownViewModel.searchTown.value
        TextField(
            value = town,
            onValueChange = { newValue -> searchByTownViewModel.onTownChange(newValue) },
            label = { Text(stringResource(id = R.string.district_for_town_edit_text_label)) })
        VerticalSpace()
        FindButton(
            onClick = { searchByTownViewModel.getDistrictForTown() },
            text = stringResource(id = R.string.district_for_town_button_text)
        )
        VerticalSpace()
        ResultText(resultDistrict)
        VerticalSpace()
        ResultText("Region")
    }
}