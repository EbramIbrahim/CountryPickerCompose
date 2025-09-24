package com.example.countrycodepickercompose.country_picker.utils


object Utils {

    fun getEmojiFlag(isoString: String): String {
        return isoString.uppercase().map { char -> Character.codePointAt("$char", 0) + 0x1F1A5 }
            .joinToString("") {
                String(Character.toChars(it))
            }
    }


    fun validatePhoneNumber(number: String): String? {
        return if (number.isBlank()) {
            "Field cannot be empty"
        } else if (number.length < 11) {
            "Phone number must be 11 characters long"
        } else {
            null // No error
        }
    }
}