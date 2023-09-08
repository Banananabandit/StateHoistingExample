package com.example.statehoistingexample

import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("r_i_id")
    val id: Int,
    @SerializedName("r_i_name")
    val name: String,
    var hasIngredient: Boolean
)

val dummyIngredients = listOf(
    Ingredient(0, "Onion", false),
    Ingredient(1, "Banana",true),
    Ingredient(2, "Chocolate",false),
    Ingredient(3, "Garlic",false)
)

