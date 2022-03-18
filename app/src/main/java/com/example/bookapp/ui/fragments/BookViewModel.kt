package com.example.bookapp.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookapp.Storage
import com.example.bookapp.models.BookModel

class BookViewModel : ViewModel() {

    val description = MutableLiveData<String>()

    fun getBooks(): List<BookModel> {
        return Storage.book()
    }

    fun putDescription(text: String) {
        description.value = text
    }

}