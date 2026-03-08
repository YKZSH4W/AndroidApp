package com.example.actividad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.actividad.ui.theme.ActividadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActividadTheme {
                DisplayCenter(3)
            }
        }
    }
}

data class Message(val title: String, val body: String)

// LoginMenu describes how to display the components
// Column to distribute all elements in a column
// Image to place images on screen
// Text to show messages
// Spacer to give a space between elements
@Composable
fun DisplayCenter(type: Int) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(type == 1) {
                MainMenu()
            } else if(type == 2) {
                LogInMenu()
            } else {
                SignUpMenu()
            }
        }
    }
}

@Composable
fun MainMenu() {
    Image(
        painter = painterResource(R.drawable.login_android),
        contentDescription = "Login main image",
        modifier = Modifier.width(300.dp).height(220.dp)
    )

    Spacer(modifier = Modifier.height(50.dp))

    Text(
        text = "Hello",
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.displaySmall
    )

    Spacer(modifier = Modifier.height(10.dp))

    Text(
        text = "Welcome To Little Drop, where you manage you daily tasks",
        color = MaterialTheme.colorScheme.tertiary,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.width(200.dp),
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(50.dp))

    Button(
        onClick = { },
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.width(200.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = Color.White
        )
    ) {
        Text("Login")
    }

    Spacer(modifier = Modifier.height(10.dp))

    Button(
        onClick = { },
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.width(200.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.secondary
        )

    ) {
        Text("Sign Up")
    }
}

@Composable
fun LogInMenu() {
    Text(
        text = "Welcome Back!",
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.displaySmall
    )

    Spacer(modifier = Modifier.height(50.dp))

    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text("Email") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        ),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))

    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text("Password") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        ),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
    )

    Spacer(modifier = Modifier.height(5.dp))

    Text(
        text = "I Forgot My Password",
        color = Color.Gray,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp),
        textAlign = TextAlign.Start,
    )

    Spacer(Modifier.height(50.dp))

    Button(
        onClick = { },
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        )

    ) {
        Text("Sign In")
    }

    Spacer(modifier = Modifier.height(5.dp))

    Button(
        onClick = { },
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.secondary
        )

    ) {
        Text("Sign Up")
    }
}

@Composable
fun SignUpMenu() {
    Text(
        text = "Create Your Account!",
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.displaySmall
    )

    Spacer(modifier = Modifier.height(50.dp))

    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text("Full Name") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        ),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))

    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text("Phone Number") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        ),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))

    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text("Email") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        ),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))

    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text("Password") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        ),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))

    OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text("Confirm Password") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.tertiary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.tertiary,
        ),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp)
    )

    Spacer(Modifier.height(50.dp))

    Button(
        onClick = { },
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier.fillMaxWidth().padding(40.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        )

    ) {
        Text("Create")
    }

    Spacer(modifier = Modifier.height(5.dp))

    Button(
        onClick = { },
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