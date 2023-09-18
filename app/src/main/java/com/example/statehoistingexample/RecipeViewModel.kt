package com.example.statehoistingexample

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RecipeViewModel: ViewModel() {
    private var restInterface: RecipesApiService
    val state = mutableStateOf(emptyList<Ingredient>())
    private lateinit var ingredientsCall: Call<List<Ingredient>>

    private fun getIngredients() {
        ingredientsCall = restInterface.getRecipes()
            ingredientsCall.enqueue(
            object : Callback<List<Ingredient>> {
                override fun onResponse(
                    call: Call<List<Ingredient>>,
                    response: Response<List<Ingredient>>
                ) {
                    response.body()?.let { toDo ->
                        state.value = toDo
                    }
                }
                override fun onFailure(call: Call<List<Ingredient>>, t: Throwable) {
                    println("THat DIDN'T FUCKING WORK")
                    t.printStackTrace()
                }
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        ingredientsCall.cancel()
    }

    fun toggleIngredients(ingredient: Ingredient, newSelection: Boolean) {
        val ingredients = state.value.toMutableList()
        val itemIndex = ingredients.indexOfFirst { it.id == ingredient.id}
        val item = ingredients[itemIndex]
        ingredients[itemIndex] = item.copy(hasIngredient = newSelection)
        state.value = ingredients
    }
    init {
        val retrofit: Retrofit = Retrofit
            .Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl("https://recipesapp-7cae7-default-rtdb.firebaseio.com/") //TODO: There might be a problem with my link. Just double check
            .build()
        restInterface = retrofit.create(RecipesApiService::class.java)

        getIngredients()
    }
}