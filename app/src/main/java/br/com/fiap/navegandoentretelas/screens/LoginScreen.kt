package br.com.fiap.navegandoentretelas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(){
    Box(
        modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFED145B))
        .padding(32.dp)
    ){
        Text(
            text = "LOGIN",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Button(
            onClick = {/* TODO */ },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.align(
                Alignment.Center
            )
        ) {
            Text(
                text = "ENTRAR",
                fontSize = 20.sp,
                color = Color.Blue
            )
        }
    }
}