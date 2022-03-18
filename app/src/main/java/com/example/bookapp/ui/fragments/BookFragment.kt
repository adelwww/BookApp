package com.example.bookapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bookapp.R
import com.example.bookapp.Storage
import com.example.bookapp.databinding.FragmentBookBinding
import com.example.bookapp.models.BookModel
import com.example.bookapp.ui.adapters.BookAdapter

class BookFragment : Fragment(R.layout.fragment_book) {

    private val binding by viewBinding(FragmentBookBinding::bind)
    private val viewModel: BookViewModel by activityViewModels()
    private val bookAdapter : BookAdapter = BookAdapter(this::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecycler()
    }

    private fun setupRecycler() = with(binding) {
        bookAdapter.setList(viewModel.getBooks())
        recyclerBook.adapter = bookAdapter
    }

    private fun onItemClick(model: BookModel){
        viewModel.putDescription(model.description)

        findNavController().navigate(
          R.id.detailBookFragment
        )
    }
}
