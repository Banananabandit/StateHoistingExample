package com.example.statehoistingexample

data class Ingredient(
    val id: Int,
    val name: String,
    var hasIngredient: Boolean
)

val dummyIngredients = listOf(
    Ingredient(0, "Onion", false),
    Ingredient(1, "Banana",true),
    Ingredient(2, "Chocolate",false),
    Ingredient(3, "Garlic",false)
)

