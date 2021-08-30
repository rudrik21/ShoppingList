package com.rudrik.shoppinglist.data.repositories

import com.rudrik.shoppinglist.data.db.ShoppingDatabase
import com.rudrik.shoppinglist.data.db.entities.ShoppingItem


class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    fun upsert(item: ShoppingItem) = db.getShoppingDAO().upsert(item)

    fun delete(item: ShoppingItem) = db.getShoppingDAO().delete(item)

    fun getAllShoppingItems() = db.getShoppingDAO().getAllShoppingItems()
}