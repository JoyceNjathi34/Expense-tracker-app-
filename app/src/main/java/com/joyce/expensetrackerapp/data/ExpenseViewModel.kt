package com.joyce.expensetrackerapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.database.FirebaseDatabase
import com.joyce.expensetrackerapp.model.Expense
import com.joyce.expensetrackerapp.navigation.ROUTE_LOGIN


class ExpenseViewModel(var navController: NavHostController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveExpense(
        expenseName: String,
        expenseQuantity: String,
        expenseCategory: String,
        expensePrice: String,
        expenseDate: String
    ) {
        var id = System.currentTimeMillis().toString()
        var expenseData =
            Expense(expenseName, expenseQuantity, expenseCategory, expensePrice, expenseDate, id)
        var expenseRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        expenseRef.setValue(expenseData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}














