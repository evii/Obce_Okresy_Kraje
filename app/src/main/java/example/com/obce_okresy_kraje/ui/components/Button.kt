package example.com.obce_okresy_kraje.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FindButton(
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = onClick,
        enabled = true,
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun FindButtonPreview() {
    FindButton(onClick = { /*TODO*/ }, text = "Find")
}