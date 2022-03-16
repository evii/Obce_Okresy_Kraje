package example.com.obce_okresy_kraje.ui.SearchByTown

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import example.com.obce_okresy_kraje.R
import example.com.obce_okresy_kraje.ui.components.FindButton
import example.com.obce_okresy_kraje.ui.components.ResultText
import example.com.obce_okresy_kraje.ui.components.SearchEditText
import example.com.obce_okresy_kraje.ui.components.TitleText
import example.com.obce_okresy_kraje.ui.components.VerticalSpace
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview
@Composable
fun SearchByTownScreen() {
    val searchByTownViewModel: SearchByTownViewModel = viewModel()
    Column(
        modifier = Modifier.padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleText(R.string.district_for_town_title)
        VerticalSpace()
        SearchEditText()
        VerticalSpace()
        FindButton(onClick = { searchByTownViewModel.launchTowns()}, text = stringResource(id = R.string.district_for_town_button_text))
        VerticalSpace()
        ResultText("District")
        VerticalSpace()
        ResultText("Region")
    }
}