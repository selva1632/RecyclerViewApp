package com.selva.recyclerviewapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.selva.recyclerviewapp.FieldData

class PersonViewItemMaker {
    fun makeProfile(
        name: String,
        @DrawableRes iconId: Int,
        @StringRes contentDescription: Int
    ): PersonViewItem {
        return PersonViewItem.ProfilePhoto(
            name = name,
            iconResId = iconId,
            contextDescription = contentDescription
        )
    }

    fun makeTitle(
        @StringRes title: Int
    ): PersonViewItem {
        return PersonViewItem.TitleItem(
            title = title,
            contextDescription = title
        )
    }

    fun makeEmpty(
        @StringRes title: Int
    ): PersonViewItem {
        return PersonViewItem.EmptyItem(
            contextDescription = title
        )
    }

    fun makeField(
        fields: List<FieldData>
    ): List<PersonViewItem> {
        val fieldItem = mutableListOf<PersonViewItem>()
        fields.forEachIndexed { index, field ->
            fieldItem.add(
                PersonViewItem.FieldItem(
                    title = field.title,
                    subTitle = field.subTitle,
                    roundType = RoundType.from(index, fields.size),
                    dividerVisibility = index == fields.size - 1
                )
            )
        }
        return fieldItem
    }
}