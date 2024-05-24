package com.joyce.expensetrackerapp.ui.theme.screens.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joyce.expensetrackerapp.navigation.ROUTE_ADD_TRANSACTION

@Composable
fun TransactionDashboard(navController:NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context= LocalContext.current
        //  var transactionData=TransactionViewModel(navController, context)
        Text(
            text = " Transaction Dashboard",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = {
            navController.navigate(ROUTE_ADD_TRANSACTION)
        }, modifier = Modifier.fillMaxWidth(),
            colors=ButtonDefaults.buttonColors(Color.Black)) {
            Text(text = "Add Transaction")

        }
    }

}
@Preview
@Composable
fun TD(){
    TransactionDashboard(rememberNavController())
}