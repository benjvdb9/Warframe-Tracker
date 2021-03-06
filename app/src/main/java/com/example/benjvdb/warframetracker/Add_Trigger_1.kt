package com.example.benjvdb.warframetracker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Button


class Add_Trigger_1 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var mDrawerlayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_trigger_1)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        var actionbar: ActionBar? = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)

        mDrawerlayout = findViewById(R.id.drawer_layout)
        var navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        configureAlertButton()
    }

    fun configureAlertButton() {
        var AlertButton: Button = findViewById(R.id.Alerts)
        AlertButton.setOnClickListener {
            startActivity(Intent(this, Add_Trigger_2::class.java))
        }

        var InvasionButton: Button = findViewById(R.id.Invasions)
        InvasionButton.setOnClickListener {
            startActivity(Intent(this, Add_Trigger_2b::class.java))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                mDrawerlayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_events -> {
                val intent = Intent(this, MainScreen::class.java)
                mDrawerlayout.closeDrawer(GravityCompat.START)
                startActivity(intent)
                true
            }
            R.id.nav_triggers -> {
                val intent = Intent(this, active_triggers::class.java)
                mDrawerlayout.closeDrawer(GravityCompat.START)
                startActivity(intent)
                true
            }
            else -> {
                false
            }
        }
    }
}