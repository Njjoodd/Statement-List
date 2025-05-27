package com.first.statementlist

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountDetails(account: Account?) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Account: ${account?.name ?: "N/A"}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Amount: ${account?.amount ?: 0.0}")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Currency: ${account?.currency ?: "N/A"}")
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { }) { Text("Deposit") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { }) { Text("Withdraw") }
        }
    }
}
