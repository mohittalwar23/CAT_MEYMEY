package com.example.catmeymey

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import java.io.File
import java.io.FileOutputStream

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val imageView: ImageView = findViewById(R.id.finalGif)
        val shareButton: Button = findViewById(R.id.shareButton)

        // Retrieve the drawableResourceId from the Intent
        val drawableResourceId = intent.getIntExtra("drawableResourceId", 0)

        // Load the GIF into the ImageView using Glide
        Glide.with(this)
            .asGif() // Specify that the resource is a GIF
            .load(drawableResourceId)
            .into(imageView)

        shareButton.setOnClickListener {
            try {
                // Convert ImageView to a Bitmap
                val bitmap = imageView.drawable.toBitmap()

                // Save the Bitmap to a temporary file in external cache directory
                val cacheDir = externalCacheDir
                val file = File(cacheDir, "shared_image.gif")
                val fileOutputStream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
                fileOutputStream.close()

                // Create and start the share intent
                val authority = applicationContext.packageName + ".provider"
                val uri = FileProvider.getUriForFile(this@SecondActivity, authority, file)

                // Log the URI for debugging
                Log.d("ShareActivity", "File URI: $uri")

                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "image/gif"
                    putExtra(Intent.EXTRA_STREAM, uri)
                }
                startActivity(Intent.createChooser(shareIntent, "Share via"))

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }



    }
}
