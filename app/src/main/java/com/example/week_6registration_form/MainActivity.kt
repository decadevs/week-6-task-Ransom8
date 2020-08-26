package com.example.week_6registration_form

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    /**
     * These are my initialised variables for all input
     */

    lateinit var nameText: EditText
    lateinit var emailText: EditText
    lateinit var phoneNumber: EditText
    lateinit var spinner: Spinner
    lateinit var name: String
    lateinit var email: String
    lateinit var number: String
    lateinit var sex: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.editTextPersonName)
        emailText = findViewById(R.id.editTextEmailAddress)
        phoneNumber = findViewById(R.id.editTextPhone)
        spinner = findViewById(R.id.spinner)

        checkers()

    }

    /**
     * This Function Checks if the entry is empty or meets the required specifications
     */

    fun checkers() {
        button.setOnClickListener {

            name = nameText.text.toString()
            email = emailText.text.toString()
            number = phoneNumber.text.toString()
            sex = spinner.selectedItem.toString()

            if (name.isEmpty() || email.isEmpty() || number.isEmpty() || sex.isEmpty()) {
                Toast.makeText(this, "All Fields are Required!!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (!checkEmailField(email)) {
                return@setOnClickListener
            } else if (!checkPhoneNumField(number)) {
                return@setOnClickListener
            } else {
                val intent = Intent(this, SecondActivity::class.java).also {
                    it.putExtra("name", name)
                    it.putExtra("email", email)
                    it.putExtra("number", number)
                    it.putExtra("sex", sex)
                }
                startActivity(intent)
            }
        }
    }

    /**
     * The email address entered is validated using regex.
      */

    fun checkEmailField(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return email.matches(emailPattern)
    }

    /**
     * The Phone Number entered is validated to check for the length and the starting values.
     * The starting value is 234 or +234 or 0 for a valid Nigerian phone number. The length is checked for each instance.
     */

    fun checkPhoneNumField(enteredPhoneNum: String): Boolean {
        return if (!Pattern.matches("[a-zA-Z]+", enteredPhoneNum)) {
            if (enteredPhoneNum.length < 11) {
                false
            } else if (enteredPhoneNum.length > 11 && enteredPhoneNum.substring(0, 4) == "+234") {
                enteredPhoneNum.length == 14 && (enteredPhoneNum[4] == '8' || enteredPhoneNum[4] == '7' || enteredPhoneNum[4] == '9')
            } else if (enteredPhoneNum.length > 11 && enteredPhoneNum.substring(0, 3) == "234") {
                enteredPhoneNum.length == 13 && (enteredPhoneNum[3] == '7' || enteredPhoneNum[3] == '8' || enteredPhoneNum[3] == '9')
            } else enteredPhoneNum.first() == '0'
        } else false
    }
}