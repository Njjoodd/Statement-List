package com.first.statementlist.viewmodel

data class Account(val name: String, var amount: Double, val currency: String)
data class AccountStatement(val date: String, val type: String, val amount: Double, val description: String, val balanceAfter: Double)

class AccountRepository {
    val accountsList: List<Account> = listOf(
        Account("Saving", 100.23, "KWD"),
        Account("Salary", 20.23, "KWD"),
        Account("Kids", 510.5, "KWD"),
        Account("Family", 1000.024, "KWD"),
        Account("Saving", 100.23, "KWD"),
        Account("Salary", 20.23, "KWD"),
        Account("Kids", 510.5, "KWD"),
        Account("Family", 1000.024, "KWD"),
        Account("Saving", 100.23, "KWD"),
        Account("Salary", 20.23, "KWD"),
        Account("Kids", 510.5, "KWD"),
        Account("Family", 1000.024, "KWD"),
        Account("Saving", 100.23, "KWD"),
        Account("Salary", 20.23, "KWD"),
        Account("Kids", 510.5, "KWD"),
        Account("Family", 1000.024, "KWD")
    )

    val statementList: List<AccountStatement> = listOf(
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
}
