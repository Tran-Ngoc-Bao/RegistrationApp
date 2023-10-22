package com.example.registrationapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout)
        // setContentView(R.layout.constraint_layout)

        /*
        Code similar to linear_layout: ll -> cl
        Ex: val button: Button = findViewById(R.id.buttonll)
        -> val button: Button = findViewById(R.id.buttoncl)
         */

        val button: Button = findViewById(R.id.buttonll)
        button.setOnClickListener { check() }
    }

    private fun check() {
        // Check First Name and Last Name
        val firstname: EditText = findViewById(R.id.firstNamell)
        val firstNameTextView: TextView = findViewById(R.id.firstNameTextViewll)
        if (firstname.text.toString() == "") {
            firstNameTextView.text = "Enter your first name"
            firstNameTextView.setTextColor((getColor(R.color.red)))
            return
        } else { // Return origin
            firstNameTextView.text = "First name"
            firstNameTextView.setTextColor((getColor(R.color.grey)))
        }
        val lastName: EditText = findViewById(R.id.lastNamell)
        val lastNameTextView: TextView = findViewById(R.id.lastNameTextViewll)
        if (lastName.text.toString() == "") {
            lastNameTextView.text = "Enter your last name"
            lastNameTextView.setTextColor((getColor(R.color.red)))
            return
        } else { // Return origin
            lastNameTextView.text = "Last name"
            lastNameTextView.setTextColor((getColor(R.color.grey)))
        }

        // Check Male or Female
        val male: RadioButton = findViewById(R.id.malell)
        val female: RadioButton = findViewById(R.id.femalell)
        val gender: TextView = findViewById(R.id.genderll)
        if (!male.isChecked && !female.isChecked) {
            gender.text = "Select your gender"
            gender.setTextColor((getColor(R.color.red)))
            return
        } else { // Return origin
            gender.text = "Gender"
            gender.setTextColor((getColor(R.color.grey)))
        }

        // Check Birthday
        val birthday: EditText = findViewById(R.id.birthdayll)
        val sb: String = birthday.text.toString()
        val birthdayTextView: TextView = findViewById(R.id.birthdayTextViewll)
        if (!checkBirthday(sb)) {
            birthdayTextView.text = "Enter your Birthday"
            birthdayTextView.setTextColor(getColor(R.color.red))
            return
        } else { // Return origin
            birthdayTextView.text = "Birthday"
            birthdayTextView.setTextColor(getColor(R.color.grey))
        }

        // Check Address
        val address: EditText = findViewById(R.id.addressll)
        val addressTextView: TextView = findViewById(R.id.addressTextViewll)
        if (address.text.toString() == "") {
            addressTextView.text = "Enter your address"
            addressTextView.setTextColor((getColor(R.color.red)))
            return
        } else { // Return origin
            addressTextView.text = "Address"
            addressTextView.setTextColor((getColor(R.color.grey)))
        }

        // Check Email
        val email: EditText = findViewById(R.id.emailll)
        val se: String = email.text.toString()
        val emailTextView: TextView = findViewById(R.id.emailTextViewll)
        if (!checkEmail(se)) {
            emailTextView.text = "Enter your Email"
            emailTextView.setTextColor(getColor(R.color.red))
            return
        } else { // Return origin
            emailTextView.text = "Email"
            emailTextView.setTextColor(getColor(R.color.grey))
        }

        // Final check with Check Box
        val checkBox: CheckBox = findViewById(R.id.checkBoxll)
        val button: Button = findViewById(R.id.buttonll)
        if (!checkBox.isChecked) {
            button.text = "Agree?"
            button.setTextColor(getColor(R.color.red))
        } else {
            button.text = "Done!"
            button.setTextColor(getColor(R.color.teal_200))
        }
    }

    // Check Birthday with format DD//MM//YYYY
    private fun checkBirthday(s: String): Boolean {
        if (s == "" || s.length != 10) return false
        val day: Int = (s[0] - '0') * 10 + (s[1] - '0')
        val month: Int = (s[3] - '0') * 10 + (s[4] - '0')
        val year: Int = (s[6] - '0') * 1000 + (s[7] - '0') * 100 + (s[8] - '0') * 10 + (s[9] - '0')
        if (year > 2018 || year < 1900) return false
        if (month < 1 || month > 12) return false
        else {
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day < 1 || day > 30) return false
            } else if (month == 2) {
                if (year % 4 == 0 && year % 100 != 0 || year % 1000 == 0) {
                    if (day < 1 || day > 29) return false
                } else if (day < 1 || day > 28) return false
            } else if (day < 1 || day > 31) return false
        }
        return true
    }

    // Very simple when check email
    private fun checkEmail(s: String): Boolean {
        if (s == "") return false
        for (element in s) {
            if (element == '@') return true
        }
        return false
    }
}