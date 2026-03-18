package com.example.actividad.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

fun isValidName(name: String): Boolean {
    return name.matches(Regex("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$"))
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isValidPhone(phone: String): Boolean {
    return phone.matches(Regex("^[0-9]{10}$"))
}

fun isValidPasswords(pass: String, confirmedPass: String): Boolean {
    return pass.isNotEmpty() && pass == confirmedPass
}

@Composable
fun SignUpMenu(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var confirmedPass by remember { mutableStateOf("") }

    val isFormValid = isValidName(name) &&
            isValidEmail(email) &&
            isValidPhone(phone) &&
            isValidPasswords(pass, confirmedPass)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create Your Account!",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displaySmall
            )

            Spacer(modifier = Modifier.height(50.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full Name") },
                isError = name.isNotEmpty() && !isValidName(name),
                modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone Number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = phone.isNotEmpty() && !isValidPhone(phone),
                modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                isError = email.isNotEmpty() && !isValidEmail(email),
                modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = pass,
                onValueChange = { pass = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = confirmedPass,
                onValueChange = { confirmedPass = it },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isError = confirmedPass.isNotEmpty() && !isValidPasswords(pass, confirmedPass),
                modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
            )

            Spacer(Modifier.height(50.dp))

            Button(
                onClick = { /* Acción de crear cuenta */ },
                shape = RoundedCornerShape(5.dp),
                enabled = isFormValid, // ✅ Botón depende de validaciones
                modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                )
            ) {
                Text("Create")
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(
                onClick = { navController.navigate("welcome") },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Text("Cancel")
            }
        }
    }
}