package dev.velasquez.botonapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NormalButton(isEnable: Boolean) {
    Button(onClick = { buttonPrint("Message from Basic Button!") }, enabled = isEnable) {
        Text(text = "Basic Button", fontSize = 20.sp)
    }
}

@Composable
fun NormalButtonWithBackground(isEnable: Boolean) {
    Button(
        onClick = { buttonPrint("Message from Basic Button!") },
        enabled = isEnable,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Text(text = "Basic Button BG", fontSize = 20.sp)
    }
}

@Composable
fun NormalTextButton(isEnable: Boolean) {
    TextButton(
        onClick = { buttonPrint("Message from Text Button!") },
        enabled = isEnable
    ) {
        Text(text = "Text Button", fontSize = 20.sp)
    }
}

@Composable
fun MyOutlineButton(text: String) {
    OutlinedButton(
        onClick = { buttonPrint("Message from Outlined Button!") },
        border = BorderStroke(3.dp, color = Color.Blue)
    ) {
        Text(text = text)

    }

}

@Composable
fun BotonIcono() {
    IconButton(onClick = { buttonPrint("Message from Icon Button!") }) {
        Icon(
            Icons.Filled.Home,
            contentDescription = "Icono home", tint = Color.Yellow, modifier = Modifier.size(50.dp)
        )
    }
}

@Composable
fun BotonSwitch() {
    var isActive by remember { mutableStateOf(false) }
    Switch(
        checked = isActive, onCheckedChange = { isActive = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Red,
            checkedTrackColor = Color.Green,
            uncheckedThumbColor = Color.Blue,
            uncheckedTrackColor = Color.Magenta
        )
    )
}

@Composable
fun ButonIconDarkMode(darkMode: MutableState<Boolean>) {
    Button(onClick = {
        darkMode.value = !darkMode.value;buttonPrint("Message from Button Dark!")
    }) {
        Icon(imageVector = Icons.Rounded.Build, contentDescription = "Add circle")
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "Dark Mode")

    }
}

@Composable
fun FloatingAction() {
    FloatingActionButton(
        onClick = { buttonPrint("Message from FloatingActionButton!") },
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Icon(
            Icons.Filled.Add, contentDescription = "add",
            modifier = Modifier.size(30.dp)
        )
    }
}

fun buttonPrint(message: String) {
    println(message)
}
