package com.joyce.expensetrackerapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.database.FirebaseDatabase
import com.joyce.expensetrackerapp.model.Transaction
import com.joyce.expensetrackerapp.navigation.ROUTE_LOGIN


class TransactionViewModel(var navController: NavHostController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait")
    }

    fun saveTransaction(amount: String, type: String, date: String) {
        val id = System.currentTimeMillis().toString()
        val transactionData = Transaction(amount, type, date, id)
        val transactionRef = FirebaseDatabase.getInstance().getReference()
            .child("Transaction/$id")
        progress.show()
        transactionRef.setValue(transactionData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR:${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}