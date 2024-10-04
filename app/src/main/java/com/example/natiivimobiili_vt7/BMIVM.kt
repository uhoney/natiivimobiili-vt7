package com.example.natiivimobiili_vt7

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIVM : ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    private val height: Int
        get() {
            return heightInput.toIntOrNull() ?: 0
        }

    private val weight: Float
        get() {
            return weightInput.toFloatOrNull() ?: 0.0f
        }

    val bmiValue: Float
        get() = calculateBmi()


    // Muulla tavalla ei oikei meinannu lähteä toimimaan kuin näin.
    // Halusin nimenomaan logiikan tänne, enkä mainactivityyn.
    // HUOM! R.string.x EI ole string, vaan Integer
    val bmiExplanation: Int
        get() = when {
            bmiValue == 0.0f -> R.string.none
            bmiValue < 17 -> R.string.ref_severe_under
            bmiValue < 18.5 -> R.string.ref_under
            bmiValue < 25 -> R.string.ref_normal
            bmiValue < 30 -> R.string.ref_fat1
            bmiValue < 35 -> R.string.ref_fat2
            bmiValue < 40 -> R.string.ref_fat3
            else -> R.string.ref_fat4
        }

    private fun calculateBmi(): Float {
        return if (weight > 0 && height > 0) {
            (weight / ((height.toFloat() / 100) * (height.toFloat() / 100)))
        } else {
            0.0f
        }
    }
}