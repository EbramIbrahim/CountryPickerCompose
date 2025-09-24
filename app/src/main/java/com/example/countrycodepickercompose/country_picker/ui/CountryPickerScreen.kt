package com.example.countrycodepickercompose.country_picker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countrycodepickercompose.country_picker.ui.component.CountryCodePickerTextField
import com.example.countrycodepickercompose.country_picker.data.Country

@Composable
fun CountryPickerScreen(
    modifier: Modifier = Modifier,
    number: String,
    selectedCountry: Country = Country.Egypt,
    onValueChange: (value: String) -> Unit,
    onChecked:(Boolean) -> Unit,
    isChecked: Boolean
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "One last step",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
            Text(
                text = "Please login or signup for a\n free account to continue",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            )

        }
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)

        ) {
            CountryCodePickerTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = onValueChange,
                number = number,
                selectedCountry = selectedCountry,
            )
            Text(
                text = "We Will use this to verifiy your account",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Light
                )
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = onChecked
            )
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black, fontSize = 13.sp)) {
                        append("I agree and comply to the")
                    }
                    append(" ")
                    withStyle(style = SpanStyle(fontSize = 13.sp, color = Color.Blue.copy(alpha = 0.6f))) {
                        append("community guidelines")
                    }
                }
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Continue",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Icon(
                    imageVector = Icons.Outlined.ArrowForward,
                    contentDescription = ""
                )
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
private fun PickerScreenPrev() {
    CountryPickerScreen(
        onValueChange = {},
        number = "",
        onChecked = {},
        isChecked = true
    )
}







