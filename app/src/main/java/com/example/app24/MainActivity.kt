package com.example.app24

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coordinator_layout_scroll_based)

        // TODO: 29.06.2021 24.2 - 24.4
        setSupportActionBar(findViewById(R.id.toolbar))

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        val appBar = findViewById<AppBarLayout>(R.id.app_bar)
        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)

        fab.setOnClickListener {
            Snackbar.make(
                findViewById<CoordinatorLayout>(R.id.coordinator_layout_1),
                "привет",
                Snackbar.LENGTH_LONG
            ).show()
        }

        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (verticalOffset == 0) {
                toolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.yellow))
            }

            if (abs(verticalOffset) == appBarLayout.scrollBarSize) {
                toolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this,R.color.red))
            }
             toolbarLayout.title = verticalOffset.toString()

        })

    }
}