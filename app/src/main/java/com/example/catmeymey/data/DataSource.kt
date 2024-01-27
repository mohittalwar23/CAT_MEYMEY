package com.example.catmeymey.data

import com.example.catmeymey.R
import com.example.catmeymey.model.Cat

object DataSource {

    val cats: List<Cat> = listOf(
        Cat(
            R.drawable.banana_before,
            "Banana Cat"
        ),
        Cat(
            R.drawable.happy,
            "Happy Cat"
        ),
        Cat(
            R.drawable.maxwell,
            "Maxwell cat"
        ),
        Cat(
            R.drawable.chippi,
            "Chippi Chippi Cat"
        ),
        Cat(
            R.drawable.drama,
            "Drama Kitten"
        )
    )
}