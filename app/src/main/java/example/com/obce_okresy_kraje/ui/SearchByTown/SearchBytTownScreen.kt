package example.com.obce_okresy_kraje.ui.SearchByTown

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import example.com.obce_okresy_kraje.R
import example.com.obce_okresy_kraje.ui.components.ResultText
import example.com.obce_okresy_kraje.ui.components.SearchEditText
import example.com.obce_okresy_kraje.ui.components.TitleText

@Preview
@Composable
fun SearchByTownScreen() {
    Column(
        modifier = Modifier.padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleText(R.string.district_for_town_title)
        Spacer(modifier = Modifier.height(40.dp))
        SearchEditText()
        Spacer(modifier = Modifier.height(40.dp))
        ResultText("District")
        Spacer(modifier = Modifier.height(40.dp))
        ResultText("Region")
    }
}