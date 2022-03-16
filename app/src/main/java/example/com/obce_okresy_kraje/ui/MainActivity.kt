package example.com.obce_okresy_kraje.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import example.com.obce_okresy_kraje.ui.SearchByTown.SearchByTownScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchByTownScreen()
        }
    }
}