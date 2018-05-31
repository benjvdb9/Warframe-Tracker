package com.example.benjvdb.warframetracker

import android.annotation.SuppressLint
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
import com.beust.klaxon.Parser
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.doAsync
import org.json.JSONObject

class MainScreen : AppCompatActivity (), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mDrawerlayout: DrawerLayout
    private val client = OkHttpClient()
    private lateinit var event_view : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainscreen)

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        var actionbar: ActionBar? = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
        actionbar?.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)

        mDrawerlayout = findViewById(R.id.drawer_layout)
        var navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        configureTriggerButton()
        getCurrentAlerts()
    }

    private fun configureTriggerButton() {
        var TriggerButton: Button = findViewById(R.id.hs_add_trigger)
        TriggerButton.setOnClickListener {
            startActivity(Intent(this, Add_Trigger_1::class.java))
        }
    }

    private fun getCurrentAlerts() {
        doAsync {
            val request : Request = Request.Builder().
                    url("http://content.ps4.warframe.com/dynamic/worldState.php").build()

            var response = client.newCall(request).execute()
            var warframe_body = response.body()!!.string()
            var warframe_dict = Parser().parse(warframe_body) as JSONObject

            event_view.text = warframe_dict["Version"].toString()
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
