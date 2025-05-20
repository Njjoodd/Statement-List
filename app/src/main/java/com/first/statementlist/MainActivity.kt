package com.first.statementlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.first.statementlist.ui.theme.StatementListTheme

data class AccountStatement(
    val date: String,
    val type: String,
    val amount: Double,
    val description: String,
    val balanceAfter: Double
)

private val statementList = listOf(
    AccountStatement("2025-03-20", "Credited", 1500.0, "Salary for March", 1800.0),
    AccountStatement("2025-04-05", "Debited", 200.0, "Groceries", 1600.0),
    AccountStatement("2025-04-10", "Debited", 153.0, "Electricity bill", 1447.0),
    AccountStatement("2025-04-15", "Credited", 10.0, "Friends collection", 1457.0),
    AccountStatement("2025-04-20", "Debited", 5.7, "Coffee shop", 1451.3),
    AccountStatement("2025-04-20", "Credited", 1500.0, "Salary for April", 2951.0),
    AccountStatement("2025-05-05", "Debited", 800.0, "Electronics", 2170.0),
    AccountStatement("2025-05-10", "Debited", 155.0, "Electricity bill", 2015.0),
    AccountStatement("2025-05-13", "Debited", 23.0, "Purchase of food", 1992.0),
    AccountStatement("2025-05-14", "Debited", 7.7, "Purchase of food", 1084.3)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StatementListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AccountStatementList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AccountStatementCard(
    statement: AccountStatement,
    modifier: Modifier = Modifier
) {
    val amountColor = if (statement.type == "Credited") Color(0xFF2E7D32) else Color(0xFFC62828)

    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = statement.date, style = MaterialTheme.typography.labelSmall)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = if (statement.type == "Credited") Icons.Default.ArrowDownward else Icons.Default.ArrowUpward,
                        contentDescription = null,
                        tint = amountColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = statement.type,
                        color = amountColor,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = statement.description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Amount: ${statement.amount} KWD",
                    color = amountColor,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp)
                )
                Text(
                    text = "Balance: ${statement.balanceAfter} KWD",
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
                )
            }
        }
    }
}

@Composable
fun AccountStatementList(modifier: Modifier = Modifier) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        itemsIndexed(statementList) { _, statement ->
            AccountStatementCard(statement = statement)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatementListPreview() {
    StatementListTheme {
        AccountStatementList()
    }
}
