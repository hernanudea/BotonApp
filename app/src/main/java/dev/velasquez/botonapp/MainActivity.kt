package dev.velasquez.botonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.velasquez.botonapp.ui.theme.BotonAppTheme
import dev.velasquez.botonapp.components.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val darkMode = remember { mutableStateOf(false) }

            BotonAppTheme(darkMode.value) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyContent(darkMode = darkMode)
                }
            }
        }
    }
}


@Composable
fun MyContent(darkMode: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .horizontalScroll(state = ScrollState(0))
    ) {
        NormalButton(true)
        SpaceH()
        NormalButtonWithBackground(true)
        SpaceH()
        NormalTextButton(isEnable = true)
        SpaceH()
        MyOutlineButton(text = "OutlinedButton")
        SpaceH()
        BotonIcono()
        SpaceH()
        BotonSwitch()
        SpaceH()
        ButonIconDarkMode(darkMode = darkMode)
        SpaceH()
        FloatingAction()
    }
}


@Preview()
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponents() {
    val darkMode = remember { mutableStateOf(false) }

    BotonAppTheme(darkMode.value) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyContent(darkMode = darkMode)
        }
    }
}