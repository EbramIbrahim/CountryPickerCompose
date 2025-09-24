package com.example.countrycodepickercompose.country_picker.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.countrycodepickercompose.data.Country
import com.example.countrycodepickercompose.utils.Utils.getEmojiFlag

@Composable
fun CountryPickerDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    onItemClicked: (item: Country) -> Unit,
    listOfCountry: List<Country>,
) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Surface(
            color = MaterialTheme.colorScheme.surface, modifier = modifier
        ) {
            LazyColumn {
                items(listOfCountry, key = { it.countryName }) { countryItem ->
                    HorizontalDivider(color = Color.LightGray)
                    CountryUI(
                        country = countryItem,
                        onCountryClicked = { onItemClicked(countryItem) },
                    )
                }
            }
        }
    }

}

@Composable
fun CountryUI(
    country: Country,
    onCountryClicked: () -> Unit,
    showCountryFlag: Boolean = true,
    showCountryIso: Boolean = false,
    showCountryCode: Boolean = true,
) {

    Row(
        Modifier
            .clickable(onClick = { onCountryClicked() })
            .padding(horizontal = 10.dp, vertical = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically

    ) {

        val countryString = if (showCountryFlag && showCountryIso) {
            (getEmojiFlag(country.countryIso)) + "  " + country.countryName + "  (" + country.countryIso + ")"
        } else if (showCountryFlag) {
            (getEmojiFlag(country.countryIso)) + "  " + country.countryName
        } else if (showCountryIso) {
            country.countryName + "  (" + country.countryIso + ")"
        } else {
            country.countryName
        }

        Text(
            text = countryString,
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp),
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )

        if (showCountryCode) {
            Text(
                text = country.countryCode, style = MaterialTheme.typography.bodyMedium
            )
        }

    }


}


@Preview(showBackground = true)
@Composable
fun CountryDialogPreview() {
    CountryPickerDialog(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(RoundedCornerShape(10.dp)),
        listOfCountry = Country.getAllCountries(),
        onDismissRequest = {},
        onItemClicked = {},
    )
}