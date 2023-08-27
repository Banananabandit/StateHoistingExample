package com.example.statehoistingexample

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RecipeViewModel: ViewModel() {
    val state = mutableStateOf(dummyIngredients)

    fun toggleIngredients(ingredient: Ingredient, newSelection: Boolean) {
        val ingredients = state.value.toMutableList()
        val itemIndex = ingredients.indexOfFirst { it.id == ingredient.id}
        val item = ingredients[itemIndex]
        ingredients[itemIndex] = item.copy(hasIngredient = newSelection)
        state.value = ingredients
    }
}