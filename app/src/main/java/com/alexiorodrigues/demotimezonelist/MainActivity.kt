package com.alexiorodrigues.demotimezonelist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTimeOffsetFromTimezone()

        Log.d("DEBUG","DEBUG 1")
    }

    fun getTimeOffsetFromTimezone(): List<String> {
        Log.d("DEBUG","DEBUG Variable declaration :D")

        val currentTimezones = TimeZone.getAvailableIDs().toList()
        var calendar: Calendar
        var currentLocalTime: Date
        val date = SimpleDateFormat("Z", Locale.getDefault())
        val currentLocalDate = SimpleDateFormat()

        val timeZonesWithOffset: MutableList<String> = mutableListOf()

        Log.d("DEBUG","DEBUG Before the cycle")
        Log.d("DEBUG", "DEBUG currentTimezones: " + currentTimezones.size)

        for (timeZone in currentTimezones) {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZone), Locale.forLanguageTag(timeZone))
            currentLocalTime = calendar.time

//            timeZonesWithOffset.add(date.format("$timeZone $currentLocalTime"))
            //Log.d("DEBUG","DEBUG currentLocalTime: " + date.format(currentLocalTime))
            //Log.d("DEBUG","DEBUG timeZone: " + timeZone)
            Log.d("DEBUG","Stuff: " + (timeZone + " " + date.format(currentLocalTime)))
        }


        Log.d("DEBUG","DEBUG Values :D")
        Log.d("DEBUG","DEBUG timeZonesWithOffset: $timeZonesWithOffset")

        //var calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.getDefault())
        //val currentLocalTime = calendar.time
        //val date = SimpleDateFormat("Z", Locale.getDefault())
        //val localTime = date.format(currentLocalTime)

        return timeZonesWithOffset.toList()
    }
}
