package com.example.userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Preview(showBackground = true)
@Composable

fun LatihanInput(modifier: Modifier = Modifier){

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }

    var gender by remember { mutableStateOf("") }

    var dataGender = listOf("Laki-Laki", "Perempuan")

    var dnama by remember { mutableStateOf("") }
    var demail by remember { mutableStateOf("") }
    var dalamat by remember { mutableStateOf("") }
    var dnotelepon by remember { mutableStateOf("") }
    var dgender by remember { mutableStateOf("") }





    Column (modifier = modifier.fillMaxSize().padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("nama") },
            placeholder = { Text("isi nama anda") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            dataGender.forEach { selectedGender ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = { gender = selectedGender }
                    )
                    Text("$selectedGender")
                }

            }
        }

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("email") },
            placeholder = { Text("isi email anda") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("alamat") },
            placeholder = { Text("isi alamat anda") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        TextField(
            value = notelepon,
            onValueChange = { notelepon = it },
            label = { Text("notelepon") },
            placeholder = { Text("isi notelepon anda") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = {
            dnama = nama
            dgender = gender
            demail = email
            dalamat = alamat
            dnotelepon = notelepon

        }) {
            Text(text = "simpan")
        }

        Tampilmhs(
            param = "Nama",
            argu = dnama
        )
        Tampilmhs(
            param = "Kelamin",
            argu = dgender
        )

        Tampilmhs(
            param = "Email",
            argu = demail
        )
        Tampilmhs(
            param = "Alamat",
            argu = dalamat
        )
        Tampilmhs(
            param = "No Telepon",
            argu = dnotelepon
        )
    }
}

@Composable
fun Tampilmhs(
    param: String, argu:String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = param,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = ": ",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}
