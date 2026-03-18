package com.example.actividad.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.actividad.components.Contact

@Composable
fun MainMenu(navController: NavController) {
    val contacts = listOf(Pair("Juan Perez", "6122345522"))

    var phone by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    val contactList = remember{ mutableStateListOf<Pair<String, String>>() }
    contactList.add(Pair("Juan Perez", "6122345522"))

    Column(
        Modifier.padding(20.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
        )

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Numero") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
        )

        LazyColumn {
            items(contactList) {
                    contact ->
                Contact(contact.first, contact.second)

            }
        }
    }

}

@Preview
@Composable
fun ShowMain() {
    val navController = rememberNavController()
    MainMenu(navController)
}