package com.joyce.expensetrackerapp.ui.theme.screens.dashboards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joyce.expensetrackerapp.navigation.ROUTE_EXPENSE_DASHBOARD
import com.joyce.expensetrackerapp.navigation.ROUTE_TRANSACTION_DASHBOARD

@Composable
fun Dashboard(navController:NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var context = LocalContext.current
            //    var expenseData=ExpenseViewModel(navController, context)
            // var transactionData=TransactionViewModel(navController, context)

            Text(
                text = "MAIN DASHBOARD ",
                color = Color.Black,
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(100.dp))

            Button(onClick = {
                navController.navigate(ROUTE_TRANSACTION_DASHBOARD)
            }, modifier = Modifier.fillMaxWidth(),
                colors= ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "Transactions")

            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                navController.navigate(ROUTE_EXPENSE_DASHBOARD)
            }, modifier = Modifier.fillMaxWidth(),
                colors=ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "Expenses")

            }

        }
    }


@Preview
@Composable
fun Dash(){
    Dashboard(rememberNavController() )
}



