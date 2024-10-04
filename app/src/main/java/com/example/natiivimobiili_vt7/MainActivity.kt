package com.example.natiivimobiili_vt7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.natiivimobiili_vt7.ui.theme.Natiivimobiilivt7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Natiivimobiilivt7Theme {
                Surface(
                    modifier = Modifier.systemBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BMIApp()
                }
            }
        }
    }
}

@Composable
fun BMIApp(model: BMIVM = viewModel()) {

    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.body_mass_index),
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        OutlinedTextField(
            value = model.heightInput,
            onValueChange = { model.heightInput = it.replace(',', '.') },
            label = { Text(stringResource(R.string.height)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = model.weightInput,
            onValueChange = { model.weightInput = it.replace(',', '.') },
            label = { Text(stringResource(R.string.weight)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = stringResource(R.string.result, model.bmiValue)
        )

        Text(
            // Kutsu pitää tehdä tuolla 'id' parametrilla
            text = stringResource(id = model.bmiExplanation)
        )
        Text(
            modifier = Modifier.padding(top = 26.dp),
            text = "Disclaimer: BMI is not a substitute for professional medical advice.\nAlso, do not get upset by yo momma jokes"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Natiivimobiilivt7Theme {
        BMIApp()
    }
}