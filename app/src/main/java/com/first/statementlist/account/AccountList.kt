package com.first.statementlist.account

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.first.statementlist.viewmodel.AccountViewModel

@Composable
fun AccountsList(
    viewModel: AccountViewModel,
    onItemClicked: (String) -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxSize().padding(8.dp)) {
        items(viewModel.accountsList) { account ->
            AccountCard(account) { onItemClicked(account.name) }
        }
    }
}
