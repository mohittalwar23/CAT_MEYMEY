package com.example.catmeymey

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val imageView: ImageView = findViewById(R.id.finalGif)

        // Retrieve the drawableResourceId from the Intent
        val drawableResourceId = intent.getIntExtra("drawableResourceId", 0)

        // Load the GIF into the ImageView using Glide
        Glide.with(this)
            .asGif() // Specify that the resource is a GIF
            .load(drawableResourceId)
            .into(imageView)
    }
}
