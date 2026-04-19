package com.example.progsicetask3_natureexplorer

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

import androidx.recyclerview.widget.LinearLayoutManager

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gallery)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val myList = listOf(
            Item("Mountain", "Beautiful mountain", R.drawable.img_mountain),
            Item("Forest", "Green forest", R.drawable.img_forest),
            Item("Ocean", "Blue ocean", R.drawable.img_ocean)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MyAdapter(myList) { item ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("desc", item.description)
            intent.putExtra("image", item.image)
            startActivity(intent)
        }

    }
}