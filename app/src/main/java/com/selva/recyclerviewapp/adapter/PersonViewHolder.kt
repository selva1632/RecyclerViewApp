package com.selva.recyclerviewapp.adapter

import android.annotation.SuppressLint
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.selva.recyclerviewapp.R
import com.selva.recyclerviewapp.recyclerviewapp.PersonTitleBinding
import com.selva.recyclerviewapp.recyclerviewapp.ProfilePhotoBinding
import com.selva.recyclerviewapp.EmptyItemBinding
import com.selva.recyclerviewapp.FieldBinding
import com.selva.recyclerviewapp.data.PersonViewItem
import com.selva.recyclerviewapp.eventlistener.PersonEvent
import com.selva.recyclerviewapp.eventlistener.PersonEventSender

sealed class PersonViewHolder(
    open val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: PersonViewItem, position: Int)

    class ProfilePhotoViewHolder(
        override val binding: ProfilePhotoBinding
    ) : PersonViewHolder(binding) {
        override fun bind(item: PersonViewItem, position: Int) {
            binding.bindingItem = item as PersonViewItem.ProfilePhoto
            Glide.with(binding.personDetailIcon.context)
                .load(R.drawable.profile_icon)
                .centerCrop()
                .into(binding.personDetailIcon)
        }
    }

    class TitleItemViewHolder(
        override val binding: PersonTitleBinding
    ) : PersonViewHolder(binding) {
        override fun bind(item: PersonViewItem, position: Int) {
            binding.bindingItem = item as PersonViewItem.TitleItem
        }
    }

    class FieldItemViewHolder(
        override val binding: FieldBinding,
        private val eventSender: PersonEventSender
    ) : PersonViewHolder(binding) {
        @SuppressLint("UseCompatLoadingForDrawables")
        override fun bind(item: PersonViewItem, position: Int) {
            binding.run {
                bindingItem = item as PersonViewItem.FieldItem
                root.apply {
                    background = context.getDrawable(item.roundType.background)
                }
                fieldItemSubtitle.visibility = if (item.subTitle.isNullOrBlank()) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
                fieldLayout.setOnClickListener {
                    eventSender.sendEvent(PersonEvent.AddField)
                }
            }
        }
    }

    class EmptyItemViewHolder(
        override val binding: EmptyItemBinding
    ) : PersonViewHolder(binding) {
        override fun bind(item: PersonViewItem, position: Int) {
            binding.bindingItem = item as PersonViewItem.EmptyItem
        }
    }
}