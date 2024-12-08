package com.selva.recyclerviewapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.selva.recyclerviewapp.recyclerviewapp.PersonTitleBinding
import com.selva.recyclerviewapp.recyclerviewapp.ProfilePhotoBinding
import com.selva.recyclerviewapp.EmptyItemBinding
import com.selva.recyclerviewapp.FieldBinding
import com.selva.recyclerviewapp.data.PersonViewItem
import com.selva.recyclerviewapp.eventlistener.PersonEventSender

class PersonAdapter(
    private val eventSender: PersonEventSender
) : RecyclerView.Adapter<PersonViewHolder>() {

    private val items = mutableListOf<PersonViewItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(item: List<PersonViewItem>) {
        items.clear()
        items.addAll(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return when (viewType) {
            TYPE_PROFILE_PHOTO -> PersonViewHolder.ProfilePhotoViewHolder(
                ProfilePhotoBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            TYPE_TITLE -> PersonViewHolder.TitleItemViewHolder(
                PersonTitleBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            TYPE_FIELD -> PersonViewHolder.FieldItemViewHolder(
                FieldBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ),
                eventSender
            )

            TYPE_EMPTY -> PersonViewHolder.EmptyItemViewHolder(
                EmptyItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )

            else -> throw IllegalArgumentException("unknown ViewType $viewType")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        val personViewItem = items[position]
        return when (personViewItem) {
            is PersonViewItem.ProfilePhoto -> TYPE_PROFILE_PHOTO
            is PersonViewItem.TitleItem -> TYPE_TITLE
            is PersonViewItem.FieldItem -> TYPE_FIELD
            is PersonViewItem.EmptyItem -> TYPE_EMPTY
        }
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(items[position], position)
        holder.binding.executePendingBindings()
    }

    companion object {
        private const val TYPE_PROFILE_PHOTO = 0
        private const val TYPE_TITLE = 1
        private const val TYPE_FIELD = 2
        private const val TYPE_EMPTY = 3
    }
}