package com.first.statementlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountCard(account: Account, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().height(100.dp).clickable { onClick() }) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Text("${account.name} Account")
            Text("${account.amount} ${account.currency}")
        }
    }
}
