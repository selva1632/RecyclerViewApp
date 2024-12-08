package com.selva.recyclerviewapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class PersonViewItem {
    data class ProfilePhoto(
        val name: String,
        @DrawableRes val iconResId: Int,
        @StringRes val contextDescription: Int
    ) : PersonViewItem()

    data class TitleItem(
        @StringRes val title: Int,
        @StringRes val contextDescription: Int
    ) : PersonViewItem()

    data class FieldItem(
        val title: String,
        val subTitle: String?,
        val roundType: RoundType,
        val dividerVisibility: Boolean
    ) : PersonViewItem()

    data class EmptyItem(
        @StringRes val contextDescription: Int
    ): PersonViewItem()
}