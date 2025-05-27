package com.first.statementlist.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AccountViewModel(private val accountRepository: AccountRepository) : ViewModel() {
    var accountsList by mutableStateOf(accountRepository.accountsList)
        private set
    var statementList by mutableStateOf(accountRepository.statementList)
        private set
    var selectedAccount = mutableStateOf<Account?>(null)
        private set
    var amount = mutableStateOf(0.0)
        private set

    fun selectAccount(name: String?) {
        selectedAccount.value = accountsList.find { it.name == name }
    }

    fun resetSelectedAccount() {
        selectedAccount.value = null
        amount.value = 0.0
    }

    fun setSelectedAmount(amount: Double) {
        this.amount.value = amount
    }

    fun withdraw(amount: Double = this.amount.value) {
        selectedAccount.value?.let {
            val updated = it.copy(amount = it.amount - amount)
            selectedAccount.value = updated
            accountsList = accountsList.map { acc -> if (acc.name == updated.name) updated else acc }
        }
    }

    fun deposit(amount: Double = this.amount.value) {
        selectedAccount.value?.let {
            val updated = it.copy(amount = it.amount + amount)
            selectedAccount.value = updated
            accountsList = accountsList.map { acc -> if (acc.name == updated.name) updated else acc }
        }
    }

    companion object {
        val Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return AccountViewModel(AccountRepository()) as T
            }
        }
    }
}
