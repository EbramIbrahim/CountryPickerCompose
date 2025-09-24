package com.example.countrycodepickercompose.country_picker.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.countrycodepickercompose.data.Country

@Composable
fun CountryCodePicker(
    modifier: Modifier = Modifier,
    selectedCountry: Country = Country.Egypt,
    countryList: List<Country> = Country.getAllCountries(),
    onCountrySelected: (Country) -> Unit,
) {

    var country by remember { mutableStateOf(selectedCountry) }
    var isPickerOpen by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.clickable {
            isPickerOpen = true
        },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        CountryItemView(country = country)

        if (isPickerOpen) {
                CountryPickerDialog(
                    modifier = Modifier.clip(shape = RoundedCornerShape(12.dp)),
                    onDismissRequest = { isPickerOpen = false },
                    onItemClicked = {
                        onCountrySelected(it)
                        country = it
                        isPickerOpen = false

                    },
                    listOfCountry = countryList,
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CountryCodePickerPreview() {
    CountryCodePicker(
        onCountrySelected = {},
    )
}