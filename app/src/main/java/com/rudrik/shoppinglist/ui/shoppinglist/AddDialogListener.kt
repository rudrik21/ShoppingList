package com.rudrik.shoppinglist.ui.shoppinglist

import com.rudrik.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}