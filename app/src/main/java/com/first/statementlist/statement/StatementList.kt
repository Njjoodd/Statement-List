package com.first.statementlist.statement

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.first.statementlist.viewmodel.AccountViewModel

@Composable
fun StatementList(
    modifier: Modifier = Modifier,
    viewModel: AccountViewModel = viewModel(factory = AccountViewModel.Factory)
) {
    val statements = viewModel.statementList

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize().padding(12.dp)
    ) {
        items(statements) { statement ->
            AccountStatementCard(statement)
        }
    }
}
