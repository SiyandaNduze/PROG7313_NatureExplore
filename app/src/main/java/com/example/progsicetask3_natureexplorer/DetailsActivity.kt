package com.example.progsicetask3_natureexplorer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.ImageView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val image = intent.getIntExtra("image", 0)

        val titleView = findViewById<TextView>(R.id.detailsTitle)
        val descView = findViewById<TextView>(R.id.detailsDesc)
        val imageView = findViewById<ImageView>(R.id.detailsImage)

        titleView.text = title
        descView.text = desc
        imageView.setImageResource(image)
    }
}