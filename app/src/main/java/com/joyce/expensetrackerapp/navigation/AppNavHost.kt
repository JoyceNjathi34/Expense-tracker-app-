package com.joyce.expensetrackerapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joyce.expensetrackerapp.ui.theme.screens.dashboards.Dashboard
import com.joyce.expensetrackerapp.ui.theme.screens.expenses.AddExpenses
import com.joyce.expensetrackerapp.ui.theme.screens.expenses.ExpenseDashboard
import com.joyce.expensetrackerapp.ui.theme.screens.home.HomeDashboard
import com.joyce.expensetrackerapp.ui.theme.screens.login.LoginScreen
import com.joyce.expensetrackerapp.ui.theme.screens.register.Registerscreen
import com.joyce.expensetrackerapp.ui.theme.screens.splash.SplashScreen
import com.joyce.expensetrackerapp.ui.theme.screens.transactions.AddTransaction
import com.joyce.expensetrackerapp.ui.theme.screens.transactions.TransactionDashboard

@Composable
fun AppNavHost(modifier: Modifier =Modifier, navController: NavHostController =rememberNavController(), startDestination:String= ROUTE_SPLASH_SCREEN){

    NavHost(navController=navController,modifier=modifier,startDestination=startDestination){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            Registerscreen(navController)
        }
        composable(ROUTE_HOME){
            HomeDashboard(navController)
        }

        composable(ROUTE_SPLASH_SCREEN){
            SplashScreen(navController )
        }

        composable(ROUTE_ADD_EXPENSE){
            AddExpenses(navController )
        }
        composable(ROUTE_ADD_TRANSACTION){
            AddTransaction(navController )
        }
        composable(ROUTE_DASHBOARD){
            Dashboard(navController )
        }
        composable(ROUTE_EXPENSE_DASHBOARD){
           ExpenseDashboard(navController)
        }
        composable(ROUTE_TRANSACTION_DASHBOARD){
            TransactionDashboard(navController )
        }





    }
}
