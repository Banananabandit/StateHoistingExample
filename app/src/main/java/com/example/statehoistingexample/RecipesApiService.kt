package com.example.statehoistingexample

import retrofit2.Call
import retrofit2.http.GET

interface RecipesApiService {
    @GET("recipes/1/r_ingredients.json")
    fun getRecipes(): Call<List<Ingredient>>
}