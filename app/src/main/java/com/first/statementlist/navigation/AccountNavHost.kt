package com.first.statementlist.navigation

import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.first.statementlist.account.AccountDetails
import com.first.statementlist.viewmodel.AccountViewModel
import com.first.statementlist.account.AccountsList
import com.first.statementlist.statement.StatementList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: AccountViewModel = viewModel(factory = AccountViewModel.Factory),
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
) {
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
                        Icon(
                            imageVector = if (showAccounts) Icons.Default.List else Icons.Default.AccountBox,
                            contentDescription = null
                        )
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
                StatementList(viewModel = viewModel)
            }

            composable(NavRoutes.ACCOUNTS_LIST.route) {
                AccountsList(
                    viewModel = viewModel,
                    onItemClicked = { accountName ->
                        viewModel.selectAccount(accountName)
                        navController.navigate(NavRoutes.ACCOUNT_DETAILS.route)
                    }
                )
            }

            composable(NavRoutes.ACCOUNT_DETAILS.route) {
                DisposableEffect(lifecycleOwner) {
                    onDispose {
                        viewModel.resetSelectedAccount()
                        viewModel.setSelectedAmount(0.0)
                    }
                }

                AccountDetails(viewModel = viewModel)
            }
        }
    }
}
