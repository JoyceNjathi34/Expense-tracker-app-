package com.joyce.expensetrackerapp.ui.theme.screens.home
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joyce.expensetrackerapp.R
import com.joyce.expensetrackerapp.navigation.ROUTE_DASHBOARD


@Composable
fun HomeDashboard(navController: NavHostController) {
  Box(modifier=Modifier.fillMaxSize()){
      Image(
          painter= painterResource(id= R.drawable.don),
          contentDescription="Home background",
          contentScale= ContentScale.FillBounds,
          modifier=Modifier.matchParentSize()
      )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context= LocalContext.current


        Text(
            text = "Welcome ",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )


        Button(onClick = {
            navController.navigate(ROUTE_DASHBOARD) },
            modifier = Modifier.padding(6.dp),
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        ) {
            Text(text = " Click Here to Proceed", fontSize = 18.sp)
        }
    }
  }
}



@Preview
@Composable
fun Homepre(){
    HomeDashboard(rememberNavController())
}

