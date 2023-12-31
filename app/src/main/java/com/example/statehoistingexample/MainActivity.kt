package com.example.statehoistingexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statehoistingexample.ui.theme.StateHoistingExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateHoistingExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Recipe()
                }
            }
        }
    }
}


@Composable
fun Recipe() {
    val viewModel: RecipeViewModel = viewModel()
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 8.dp
        )
    ) {
        items(viewModel.state.value) { ingredient ->
            IngredientItem(ingredient.name, ingredient.hasIngredient) { newSelection ->
                viewModel.toggleIngredients(ingredient, newSelection)
            }
        }
    }
}

//
@Composable
fun IngredientCheckbox() {
    var state = remember { mutableStateOf(false) }
    Checkbox(
        checked = state.value,
        onCheckedChange = {state.value = it})
}
@Composable
fun IngredientItem(
    ingredient: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = ingredient,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun StatefulIngredientItem(ingredient: Ingredient) {
    var checkedState by remember { mutableStateOf(ingredient.hasIngredient) }
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Checkbox(
            checked = checkedState,
            onCheckedChange = { checkedState = !checkedState }
        )
        Text(
            text = ingredient.name,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateHoistingExampleTheme {
    }
}
