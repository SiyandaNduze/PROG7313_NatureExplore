package com.example.progsicetask3_natureexplorer

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {
        private lateinit var drawerLayout: DrawerLayout
        private lateinit var navView: NavigationView
        private lateinit var toolbar: Toolbar

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // hooks
            drawerLayout = findViewById(R.id.drawer_layout)
            navView = findViewById(R.id.nav_view)
            toolbar = findViewById(R.id.toolbar)

            // setting up toolbar
            setSupportActionBar(toolbar)

            // shows this heading on the menu dropdown
            supportActionBar?.title = "Nature Explore"

            // the drawer toggle button (hamburger)
            val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.nav_drawer_open,
                R.string.nav_drawer_close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            // Handle menu item clicks
            navView.setNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                     R.id.nav_home -> showMessage("Home Page Toast")

                    //R.id.nav_home -> {
                      //  supportActionBar?.title = "Home"
                    //}

                    //adding explicit intents for gallery (can switch between the screens)
                    R.id.nav_gallery -> {
                        supportActionBar?.title = "Gallery"
                        val intent = Intent(this, GalleryActivity::class.java)
                        startActivity(intent)
                    }

                    //adding implicit intents so a website opens when u click on 'favourites
                    R.id.nav_websites -> {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse("https://www.nationalgeographic.com")
                        startActivity(intent)
                    }

                    //implicit intents - can send an email when opening settings
                    R.id.nav_email -> {
                        val intent = Intent(Intent.ACTION_SENDTO)
                        intent.data = Uri.parse("mailto:example@gmail.com")
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Nature Explorer Inquiry")
                        startActivity(intent)
                    }
                }
                drawerLayout.closeDrawers()
                true
            }
        }

        private fun showMessage(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }