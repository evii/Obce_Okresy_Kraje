package example.com.obce_okresy_kraje.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import example.com.obce_okresy_kraje.R

@Composable
fun SearchEditText() {
    var town by rememberSaveable { mutableStateOf("") }
    TextField(
        value = town,
        onValueChange = { town = it },
        label = { Text(stringResource(id = R.string.district_for_town_edit_text_label)) })
}