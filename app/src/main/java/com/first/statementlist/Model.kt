package com.first.statementlist

data class Account(val name: String, var amount: Double, val currency: String)
data class AccountStatement(val date: String, val type: String, val amount: Double, val description: String, val balanceAfter: Double)
