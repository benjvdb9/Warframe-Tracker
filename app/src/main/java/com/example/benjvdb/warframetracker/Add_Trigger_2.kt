package com.example.benjvdb.warframetracker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView


open class Add_Trigger_2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var mDrawerlayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_trigger_2)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        var actionbar: ActionBar? = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)

        mDrawerlayout = findViewById(R.id.drawer_layout)
        var navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        registerEvents()
        addTrigger()
    }

    open fun registerEvents() {
        val Title: TextView = findViewById(R.id.at_Events)
        Title.setText("ALERTS")
    }

    fun addTrigger() {
        var AddButton: Button = findViewById(R.id.at_add_trigger)
        AddButton.setOnClickListener {
            val path = this.filesDir
            val TriggerFile = WarframeUtility.setupFilePath(path)
            val TriggerInfo = getTriggerInfo()
            TriggerFile.appendText(TriggerInfo)
            Log.d("TriggerInfo", TriggerInfo)
            startActivity(Intent(this, active_triggers::class.java))
        }
    }

    open fun getTriggerInfo() : String {
        val minLVL: TextView = findViewById(R.id.Alarm_lvlMin)
        val maxLVL: TextView = findViewById(R.id.Alarm_lvlMax)
        val Search: TextView = findViewById(R.id.TriggerSearch)

        val TriggerInfo = "A: ${minLVL.text}-${maxLVL.text}, ${Search.text}\n\n"
        return TriggerInfo
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
                mDrawerlayout.openDrawer(GravityCompat.START)
                startActivity(intent)
                true
            }
            R.id.nav_triggers -> {
                val intent = Intent(this, active_triggers::class.java)
                mDrawerlayout.openDrawer(GravityCompat.START)
                startActivity(intent)
                true
            }
            else -> {
                false
            }
        }
    }
}