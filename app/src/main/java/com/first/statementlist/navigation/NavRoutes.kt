package com.first.statementlist.navigation

enum class NavRoutes(val route: String) {
    ACCOUNTS_LIST("accountsList"),
    ACCOUNT_DETAILS("accountDetails/{accountName}"),
    STATEMENT_LIST("statementList");

    companion object {
        fun accountDetails(accountName: String) = "accountDetails/$accountName"
    }
}
