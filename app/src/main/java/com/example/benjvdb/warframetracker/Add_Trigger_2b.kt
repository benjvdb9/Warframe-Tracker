package com.example.benjvdb.warframetracker

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.widget.TextView

/**
 * Created by Benj VDB on 22/05/2018.
 */
class Add_Trigger_2b : Add_Trigger_2() {

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

    override fun registerEvents() {
        var Title: TextView = findViewById(R.id.at_Events)
        Title.setText("INVASIONS")
    }

    override fun getTriggerInfo(): String {
        val minLVL: TextView = findViewById(R.id.Alarm_lvlMin)
        val maxLVL: TextView = findViewById(R.id.Alarm_lvlMax)
        val Search: TextView = findViewById(R.id.TriggerSearch)

        var TriggerInfo = "I: ${minLVL.text}-${maxLVL.text}, ${Search.text}\n\n"
        return TriggerInfo
    }
}