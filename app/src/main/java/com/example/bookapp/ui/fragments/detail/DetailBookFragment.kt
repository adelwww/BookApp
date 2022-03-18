package com.example.bookapp.ui.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bookapp.R
import com.example.bookapp.Storage
import com.example.bookapp.databinding.FragmentDetailBookBinding
import com.example.bookapp.models.BookModel
import com.example.bookapp.ui.fragments.BookViewModel
import kotlinx.coroutines.launch


class DetailBookFragment : Fragment(R.layout.fragment_detail_book) {

    private val binding by viewBinding(FragmentDetailBookBinding::bind)
    private val viewModel: BookViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpDescription()
    }

    private fun setUpDescription() = with(binding) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.description.observe(viewLifecycleOwner) { description ->
                binding.descriptionTv.text = description.toString()

            }
        }
    }
}