package com.joyce.expensetrackerapp.ui.theme.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.joyce.expensetrackerapp.data.AuthViewModel
import com.joyce.expensetrackerapp.navigation.ROUTE_LOGIN

@Composable
fun Registerscreen(navController: NavHostController){
  var email by remember{ mutableStateOf(TextFieldValue("")) }
  var pass by remember{ mutableStateOf(TextFieldValue("")) }
  var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
  val context= LocalContext.current
  Column(modifier= Modifier
      .fillMaxSize()
      .background(Color.Cyan),
      horizontalAlignment = Alignment.CenterHorizontally) {

      Text(text = "Register here",
          color= Color.Blue,
          fontFamily = FontFamily.Cursive,
          fontSize = 38.sp)

      Spacer(modifier=Modifier.height(20.dp))

      OutlinedTextField(value = email, onValueChange = {email=it},
         label={ Text(text = "Enter Email")},
          keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next ),
          modifier= Modifier
              .fillMaxWidth()
              .padding(8.dp))
      Spacer(modifier=Modifier.height(20.dp))
      
      OutlinedTextField(value= pass, onValueChange={pass=it},
          label={ Text(text ="Enter Password" )},
          keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
          modifier = Modifier
              .fillMaxWidth()
              .padding(8.dp))
      Spacer(modifier = Modifier.height(20.dp))

      
      OutlinedTextField(value = confirmpass, onValueChange = {confirmpass=it},
          label={ Text(text = "Confirm Password")},
          keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
          modifier= Modifier
              .fillMaxWidth()
              .padding(8.dp))
      
      Spacer(modifier=Modifier.height(20.dp))
      
      Button(onClick = {
          val myregister= AuthViewModel(navController,context)
          myregister.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())
      },modifier=Modifier.fillMaxWidth()) {
          Text(text = "Register")
          
      }
      Spacer(modifier = Modifier.height(20.dp))
      
      Button(onClick = {
          navController.navigate(ROUTE_LOGIN)
      },modifier=Modifier.fillMaxWidth()) {
          Text(text = "Have an Account? Click to Login")
      }
  }
}


@Preview
@Composable
fun Reg(){
    Registerscreen(rememberNavController())
}