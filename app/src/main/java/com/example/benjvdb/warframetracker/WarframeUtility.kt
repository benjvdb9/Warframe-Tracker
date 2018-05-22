package com.example.benjvdb.warframetracker

import android.content.Context
import android.content.Intent
import android.support.design.widget.NavigationView
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import java.io.File

/**
 * Created by Benj VDB on 02/05/2018.
 */
class WarframeUtility : AppCompatActivity() {
    companion object {
        /*fun NavigateDrawer(item: MenuItem, mDrawerlayout: DrawerLayout, packageContext: Context) : Boolean {
            return when (item.itemId) {
                R.id.nav_events -> {
                    val intent = Intent(packageContext, MainScreen::class.java)
                    mDrawerlayout.closeDrawer(GravityCompat.END)
                    startActivity(
                            packageContext,
                            intent
                    )
                    true
                }
                R.id.nav_triggers -> {
                    val intent = Intent(packageContext, Add_Trigger_1::class.java)
                    mDrawerlayout.closeDrawer(GravityCompat.END)
                    startActivity(packageContext, intent)
                    true
                }
                else -> {
                    false
                }
            }
        }*/

        fun setupFilePath(path: File) : File {
            val WFDirectory = File(path, "WFTracker")
            WFDirectory.mkdirs()
            val file = File(WFDirectory, "Active_Triggers.txt")
            return file
        }
    }
}