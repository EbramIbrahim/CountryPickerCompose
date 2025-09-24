package com.example.countrycodepickercompose.country_picker.ui.component


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.countrycodepickercompose.data.Country


@Composable
fun CountryCodePickerTextField(
    modifier: Modifier = Modifier,
    number: String,
    onValueChange: (value: String) -> Unit,
    selectedCountry: Country = Country.Egypt,
    countryList: List<Country> = Country.getAllCountries(),
) {


    var country by remember {
        mutableStateOf(selectedCountry)
    }


    OutlinedTextField(
        value = number,
        onValueChange = {
            onValueChange(it)
        },
        modifier = modifier,
        textStyle = MaterialTheme.typography.bodyMedium,
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        placeholder = {
            Text("xxxxxxxxxxx")
        },
        leadingIcon = {
            CountryCodePicker(
                selectedCountry = country,
                countryList = countryList,
                onCountrySelected = {
                    country = it
                    onValueChange(number)
                },
            )

        },
        enabled = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Phone
        ),
        colors = OutlinedTextFieldDefaults.colors()
    )


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    var value by remember {
        mutableStateOf("")
    }

    CountryCodePickerTextField(onValueChange = { number ->
        value = number

    }, number = value)
}