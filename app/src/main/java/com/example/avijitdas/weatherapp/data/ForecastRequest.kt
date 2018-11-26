package com.example.avijitdas.weatherapp.data

import com.google.gson.Gson
import java.net.URL

class ForecastRequest(private val zipCode: String)
{
    companion object {
        private val APP_ID = "b6907d289e10d714a6e88b30761fae22"
        private val URL = "https://samples.openweathermap.org/data/2.5/forecast/daily?"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&id="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}