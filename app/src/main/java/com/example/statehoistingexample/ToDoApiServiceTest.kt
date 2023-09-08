package com.example.statehoistingexample

import retrofit2.Call
import retrofit2.http.GET

interface ToDoApiServiceTest {
    @GET("/todos?userId=1")
    fun getTodo(): Call<List<ToDoTest>>
}