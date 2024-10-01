package com.example.natiivimobiili_vt7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.natiivimobiili_vt7.ui.theme.Natiivimobiilivt7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Natiivimobiilivt7Theme {
                Surface(modifier = Modifier.systemBarsPadding()) {
                    BMIApp()
                }
            }
        }
    }
}

@Composable
fun BMIApp() {
    Text(
        "hello world"
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Natiivimobiilivt7Theme {
        BMIApp()
    }
}