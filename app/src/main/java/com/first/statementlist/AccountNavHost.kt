package com.first.statementlist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsNavHost() {
    val navController = rememberNavController()
    var showAccounts by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bank App") },
                actions = {
                    IconButton(onClick = {
                        showAccounts = !showAccounts
                        if (showAccounts) {
                            navController.navigate(NavRoutes.ACCOUNTS_LIST.route) {
                                popUpTo(navController.graph.startDestinationId) { inclusive = true }
                            }
                        } else {
                            navController.navigate(NavRoutes.STATEMENT_LIST.route) {
                                popUpTo(navController.graph.startDestinationId) { inclusive = true }
                            }
                        }
                    }) {
                        Icon(imageVector = if (showAccounts) Icons.Default.List else Icons.Default.AccountBox, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.STATEMENT_LIST.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavRoutes.STATEMENT_LIST.route) {
                StatementList()
            }
            composable(NavRoutes.ACCOUNTS_LIST.route) {
                AccountsList(accountsList) { accountName ->
                    navController.navigate(NavRoutes.accountDetails(accountName))
                }
            }
            composable(NavRoutes.ACCOUNT_DETAILS.route) { backStackEntry ->
                val accountName = backStackEntry.arguments?.getString("accountName")
                val account = accountsList.find { it.name == accountName }
                AccountDetails(account)
            }
        }
    }
}
