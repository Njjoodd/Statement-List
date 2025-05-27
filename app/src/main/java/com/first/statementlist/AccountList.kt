package com.first.statementlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountsList(accountsList: List<Account>, onItemClicked: (String) -> Unit) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxSize().padding(8.dp)) {
        items(accountsList) { account ->
            AccountCard(account) { onItemClicked(account.name) }
        }
    }
}
