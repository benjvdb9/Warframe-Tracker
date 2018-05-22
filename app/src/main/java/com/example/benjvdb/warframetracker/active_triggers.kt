package com.example.benjvdb.warframetracker

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import java.io.FileInputStream

/**
 * Created by Benj VDB on 22/05/2018.
 */
class active_triggers : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mDrawerlayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.active_triggers)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        var actionbar: ActionBar? = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)

        mDrawerlayout = findViewById(R.id.drawer_layout)
        var navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        displayTriggers()
    }

    fun displayTriggers() {
        var TriggerTextView: TextView = findViewById(R.id.Triggers_Text)
        var testText = "\n\nA: 1-99, anything\n\nI: 30-40, nitain"
        val path = this.filesDir
        var TriggerFile = WarframeUtility.setupFilePath(path)
        var TriggerText : String

        try { TriggerText = FileInputStream(TriggerFile)?.bufferedReader()?.use{ it?.readText() } }
        catch(e: Exception) { TriggerText = "No active triggers found" }

        TriggerTextView.setText(TriggerText)
        deleteTriggers()
    }

    fun deleteTriggers() {
        val path = this.filesDir
        var TriggerFile = WarframeUtility.setupFilePath(path)
        var deleteButton: Button = findViewById(R.id.at_del_trigger)

        deleteButton.setOnClickListener {
            TriggerFile.delete()
            finish()
            startActivity(intent)
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