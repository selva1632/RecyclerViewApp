package com.selva.recyclerviewapp.data

import androidx.annotation.DrawableRes
import com.selva.recyclerviewapp.R

enum class RoundType(
    @DrawableRes val background: Int,
) {
    ALL(background = R.drawable.add_background),
    TOP(background = R.drawable.item_top_background),
    BOTTOM(background = R.drawable.item_bottom_background),
    NONE(background = R.drawable.item_none_background);

    companion object {
        fun from(position: Int, size: Int): RoundType {
            return if (position == 0 && size == 1) {
                ALL
            } else if (position == 0) {
                TOP
            } else if (position == size - 1) {
                BOTTOM
            } else {
                NONE
            }
        }
    }
}