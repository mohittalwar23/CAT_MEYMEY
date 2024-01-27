package com.example.catmeymey.model

import androidx.annotation.DrawableRes

data class Cat(
    @DrawableRes val imageResourceId: Int,
    val name: String
)