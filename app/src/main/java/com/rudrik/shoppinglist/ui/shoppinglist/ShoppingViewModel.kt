package com.rudrik.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.rudrik.shoppinglist.data.db.entities.ShoppingItem
import com.rudrik.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.*

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun upsert(item : ShoppingItem) = CoroutineScope(Dispatchers.Default).launch {
        repository.upsert(item)
    }

    fun delete(item : ShoppingItem) = CoroutineScope(Dispatchers.Default).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}