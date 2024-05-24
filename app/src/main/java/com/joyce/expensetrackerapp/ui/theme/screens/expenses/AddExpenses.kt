package com.joyce.expensetrackerapp.ui.theme.screens.expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.joyce.expensetrackerapp.data.ExpenseViewModel


@Composable
fun AddExpenses(navController: NavHostController) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val context = LocalContext.current
            Text(
                text = "Add Expense",
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Red,
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Medium,
                textDecoration = TextDecoration.Underline
            )

            var expenseName by remember { mutableStateOf(TextFieldValue("")) }
            var expenseQuantity by remember { mutableStateOf(TextFieldValue("")) }
            var expenseCategory by remember { mutableStateOf(TextFieldValue("")) }
            var expensePrice by remember { mutableStateOf(TextFieldValue("")) }
            var expenseDate by remember { mutableStateOf(TextFieldValue("")) }



            OutlinedTextField(
                value = expenseName,
                onValueChange = { expenseName = it },
                label = { Text(text = "Expense Name ") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = expenseQuantity, onValueChange = { expenseQuantity = it },
                label = { Text(text = "Expense Quantity") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = expenseCategory, onValueChange = { expenseCategory = it },
                label = { Text(text = "Expense Category") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = expensePrice, onValueChange = { expensePrice = it },
                label = { Text(text = "Expense Price") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Spacer(modifier = Modifier.height(20.dp))


            OutlinedTextField(
                value = expenseDate, onValueChange = { expenseDate = it },
                label = { Text(text = "Date") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE SAVE LOGIC HERE---------------//
                val expenseRepository = ExpenseViewModel(navController, context)
                expenseRepository.saveExpense(
                    expenseName.text.trim(),
                    expenseQuantity.text.trim(),
                    expenseCategory.text.trim(),
                    expensePrice.text.trim(),
                    expenseDate.text.trim()
                )


            },
                modifier=Modifier.padding(6.dp),
                colors= ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "Save")
            }


        }
    }






@Preview
@Composable
fun AddER() {
    AddExpenses(rememberNavController())

}