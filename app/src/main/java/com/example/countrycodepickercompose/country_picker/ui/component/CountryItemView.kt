package com.example.countrycodepickercompose.country_picker.ui.component


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.countrycodepickercompose.data.Country
import com.example.countrycodepickercompose.utils.Utils.getEmojiFlag

@Composable
fun CountryItemView(
    country: Country,
) {

    Row(
        modifier = Modifier.padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = getEmojiFlag(country.countryIso),
            modifier = Modifier.padding(start = 5.dp, end = 5.dp).size(20.dp),
            style = MaterialTheme.typography.bodyMedium
        )

        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = null,
        )
        Text(
            text = country.countryCode,
            modifier = Modifier.padding(end = 5.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

