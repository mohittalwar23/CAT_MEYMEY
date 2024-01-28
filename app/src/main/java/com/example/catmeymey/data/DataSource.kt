package com.example.catmeymey.data

import com.example.catmeymey.R
import com.example.catmeymey.model.Cat

object DataSource {

    val cats: List<Cat> = listOf(
        Cat(
            R.drawable.banana,
            "Banana Cat",
            R.raw.banana
        ),
        Cat(
            R.drawable.happy,
            "Happy Cat",
            R.raw.happy
        ),
        Cat(
            R.drawable.maxwell,
            "Maxwell cat",
            R.raw.maxwell
        ),
        Cat(
            R.drawable.chippi,
            "Chippi Chippi Cat",
            R.raw.chippi
        ),
        Cat(
            R.drawable.drama,
            "Drama Kitten",
            R.raw.drama
        )
    )
}