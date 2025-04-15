package com.example.cyberpunk30days.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cyberpunk30days.R

data class CyberpunkCard(
    val day: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val description: Int
)

val cards = listOf(
    CyberpunkCard(1, R.drawable.cyberpunkcard1, R.string.name_1, R.string.description_1),
    CyberpunkCard(2, R.drawable.cyberpunkcard2, R.string.name_2, R.string.description_2),
    CyberpunkCard(3, R.drawable.cyberpunkcard3, R.string.name_3, R.string.description_3),
    CyberpunkCard(4, R.drawable.cyberpunkcard4, R.string.name_4, R.string.description_4),
    CyberpunkCard(5, R.drawable.cyberpunkcard5, R.string.name_5, R.string.description_5),
    CyberpunkCard(6, R.drawable.cyberpunkcard6, R.string.name_6, R.string.description_6),
    CyberpunkCard(7, R.drawable.cyberpunkcard7, R.string.name_7, R.string.description_7),
    CyberpunkCard(8, R.drawable.cyberpunkcard8, R.string.name_8, R.string.description_8),
    CyberpunkCard(9, R.drawable.cyberpunkcard9, R.string.name_9, R.string.description_9),
    CyberpunkCard(10, R.drawable.cyberpunkcard10, R.string.name_10, R.string.description_10),
    CyberpunkCard(11, R.drawable.cyberpunkcard11, R.string.name_11, R.string.description_11),
    CyberpunkCard(12, R.drawable.cyberpunkcard12, R.string.name_12, R.string.description_12),
    CyberpunkCard(13, R.drawable.cyberpunkcard13, R.string.name_13, R.string.description_13),
    CyberpunkCard(14, R.drawable.cyberpunkcard14, R.string.name_14, R.string.description_14),
    CyberpunkCard(15, R.drawable.cyberpunkcard15, R.string.name_15, R.string.description_15),
    CyberpunkCard(16, R.drawable.cyberpunkcard16, R.string.name_16, R.string.description_16),
    CyberpunkCard(17, R.drawable.cyberpunkcard17, R.string.name_17, R.string.description_17),
    CyberpunkCard(18, R.drawable.cyberpunkcard18, R.string.name_18, R.string.description_18),
    CyberpunkCard(19, R.drawable.cyberpunkcard19, R.string.name_19, R.string.description_19),
    CyberpunkCard(20, R.drawable.cyberpunkcard20, R.string.name_20, R.string.description_20),
    CyberpunkCard(21, R.drawable.cyberpunkcard21, R.string.name_21, R.string.description_21),
    CyberpunkCard(22, R.drawable.cyberpunkcard22, R.string.name_22, R.string.description_22),
    CyberpunkCard(23, R.drawable.cyberpunkcard23, R.string.name_23, R.string.description_23),
    CyberpunkCard(24, R.drawable.cyberpunkcard24, R.string.name_24, R.string.description_24),
    CyberpunkCard(25, R.drawable.cyberpunkcard25, R.string.name_25, R.string.description_25),
    CyberpunkCard(26, R.drawable.cyberpunkcard26, R.string.name_26, R.string.description_26),
    CyberpunkCard(27, R.drawable.cyberpunkcard27, R.string.name_27, R.string.description_27),
    CyberpunkCard(28, R.drawable.cyberpunkcard28, R.string.name_28, R.string.description_28),
    CyberpunkCard(29, R.drawable.cyberpunkcard29, R.string.name_29, R.string.description_29),
    CyberpunkCard(30, R.drawable.cyberpunkcard30, R.string.name_30, R.string.description_30)
)