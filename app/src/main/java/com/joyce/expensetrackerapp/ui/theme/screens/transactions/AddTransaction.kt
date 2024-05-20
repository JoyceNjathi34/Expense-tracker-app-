package com.joyce.expensetrackerapp.ui.theme.screens.transactions



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.joyce.expensetrackerapp.data.TransactionViewModel



@Composable
fun AddTransaction(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Add Transaction",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Blue,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline
        )

        var amount by remember { mutableStateOf(TextFieldValue("")) }
        var type by remember { mutableStateOf(TextFieldValue("")) }
        var date by remember { mutableStateOf(TextFieldValue("")) }



        OutlinedTextField(
            value =amount,
            onValueChange = {amount=it },
            label = { Text(text = "Transaction Name ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = type, onValueChange = {type=it},
            label={Text(text="Transaction Type")},
            keyboardOptions=KeyboardOptions(keyboardType= KeyboardType.Text))

        Spacer(modifier = Modifier.height(20.dp))


        OutlinedTextField(value = date, onValueChange = {date=it},
            label={ Text(text = "Date")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE SAVE LOGIC HERE---------------//
            var transactionRepository= TransactionViewModel(navController,context)
            transactionRepository.saveTransaction(amount.text,type.text.trim(),
                date.text.trim())




        }) {
            Text(text = "Save")
        }


    }
}




@Preview
@Composable
fun AddER() {
    AddTransaction(rememberNavController())

}