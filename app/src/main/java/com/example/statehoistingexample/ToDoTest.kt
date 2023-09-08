package com.example.statehoistingexample

import com.google.gson.annotations.SerializedName

data class ToDoTest(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    var completed: Boolean = false
)
