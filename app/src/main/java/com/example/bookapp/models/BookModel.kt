package com.example.bookapp.models

import java.io.Serializable

data class BookModel(
    val title: String,
    val description: String,
    val image: Int
):Serializable
