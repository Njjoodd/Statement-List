package com.first.statementlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatementList(modifier: Modifier = Modifier) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier.fillMaxSize().padding(12.dp)) {
        items(statementList) { statement ->
            AccountStatementCard(statement)
        }
    }
}
