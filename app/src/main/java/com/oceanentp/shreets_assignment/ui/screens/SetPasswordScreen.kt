package com.oceanentp.shreets_assignment.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oceanentp.shreets_assignment.ui.theme.DarkText
import com.oceanentp.shreets_assignment.ui.theme.LightTealBackground
import com.oceanentp.shreets_assignment.ui.theme.PrimaryTeal
import com.oceanentp.shreets_assignment.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetPasswordScreen(onSaveClicked: () -> Unit, innerPadding: PaddingValues) {
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var isValid by remember { mutableStateOf(true) }
    val focusManager = LocalFocusManager.current

    isValid = confirmPassword.isEmpty() || password == confirmPassword

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(LightTealBackground)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Set Password",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = DarkText
        )

        Spacer(modifier = Modifier.height(48.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                "Enter Password",
                fontSize = 14.sp,
                color = DarkText,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Down) }),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = White,
                    unfocusedContainerColor = White,
                    focusedIndicatorColor = Color.Cyan,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                "Re-enter Password",
                fontSize = 14.sp,
                color = DarkText,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            TextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    if (password.isNotEmpty() && password == confirmPassword) {
                        focusManager.clearFocus()
                        onSaveClicked()
                    }
                }),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = White,
                    unfocusedContainerColor = White,
                    focusedIndicatorColor = if (isValid) {
                        Color.Cyan
                    } else {
                        Color.Red
                    },
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        if (!isValid) {
            Box(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = Color.Red.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Passwords don't match",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Red
                )
            }
        } else {
            Button(
                onClick = { if (password.isNotEmpty()) onSaveClicked() },
                enabled = password.isNotEmpty() && password == confirmPassword,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryTeal)
            ) {
                Text(text = "Save", fontSize = 18.sp, color = White)
            }
        }
    }
}

@Preview
@Composable
private fun SetPassPrev() {
    SetPasswordScreen(onSaveClicked = {}, innerPadding = PaddingValues(0.dp))
}