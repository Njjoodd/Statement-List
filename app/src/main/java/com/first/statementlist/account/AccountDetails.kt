package com.first.statementlist.account

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.first.statementlist.viewmodel.AccountViewModel

@Composable
fun AccountDetails(
    viewModel: AccountViewModel
) {
    val account = viewModel.selectedAccount.value
    val amount = viewModel.amount.value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Account: ${account?.name ?: "N/A"}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Amount: ${account?.amount ?: 0.0}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Currency: ${account?.currency ?: "N/A"}")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = amount.toString(),
            onValueChange = { newValue ->
                val value = newValue.toDoubleOrNull() ?: 0.0
                viewModel.setSelectedAmount(value)
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            label = { Text("Amount") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(
                onClick = { viewModel.deposit() },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Deposit")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { viewModel.withdraw() },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Withdraw")
            }
        }
    }
}

