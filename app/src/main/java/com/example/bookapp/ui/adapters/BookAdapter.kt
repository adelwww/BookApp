package com.example.bookapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookapp.databinding.ItemBookBinding
import com.example.bookapp.models.BookModel

class BookAdapter(
    val onItemClick: (BookModel) ->Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var list: List<BookModel> = arrayListOf()

    fun setList(list: List<BookModel>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
         BookViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class BookViewHolder(
        private val binding: ItemBookBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun onBind(bookModel: BookModel) = with(binding) {
            binding.bookCv.setOnClickListener {
                onItemClick(bookModel)
            }

            nameTv.text = bookModel.title
            Glide.with(bookIm).load(bookModel.image).into(bookIm)

        }

    }

}

