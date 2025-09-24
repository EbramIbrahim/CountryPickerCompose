package com.example.countrycodepickercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.countrycodepickercompose.country_picker.ui.CountryPickerScreen
import com.example.countrycodepickercompose.country_picker.ui.component.CountryCodePickerTextField
import com.example.countrycodepickercompose.data.Country
import com.example.countrycodepickercompose.ui.theme.CountryCodePickerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountryCodePickerComposeTheme {
                var text by remember {
                    mutableStateOf("")
                }
                var isChecked by remember {
                    mutableStateOf(false)
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CountryPickerScreen(
                        modifier = Modifier
                            .padding(innerPadding),
                        onValueChange = { value ->
                            text = value
                        },
                        number = text,
                        onChecked = {
                            isChecked = it
                        },
                        isChecked = isChecked,
                    )
                }
            }
        }
    }
}
