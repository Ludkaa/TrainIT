package com.example.trainit

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.json.JSONObject
import java.net.URL

/**
 * Weather fragment
 *
 * @constructor Create empty Weather fragment
 */
class WeatherFragment : Fragment(), LocationListener{
    val API: String = "06c921750b9a82d8f5d1294e1586276f"
    var URL: String = ""
    private lateinit var locationManager: LocationManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //pri staceni buttonu back
        view.findViewById<Button>(R.id.button_back).setOnClickListener {
            findNavController().navigate(R.id.action_WeatherFragment_to_MenuFragment)
        }

        //zavola funkciu getLocation
        getLocation()
    }

     //locationManager zisti aktualnu polohu
     @SuppressLint("MissingPermission")
     private fun getLocation() {
         locationManager = (requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager)
         locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 5f, this)
     }

    /**
     * Weather task - rozšírenie triedy
     *
     * @constructor Create empty Weather task
     */
    inner class weatherTask : AsyncTask<String, Void, String>() {
        override fun doInBackground(vararg params: String?): String? {
            var response:String?
            try{
                response = URL(URL).readText(
                    Charsets.UTF_8
                )
            }catch (e: Exception){
                response = null
            }
            return response
        }

        //výsledok počasia
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                /* Extracting JSON returns from the API */
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val wind = jsonObj.getJSONObject("wind")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)

                val temp = main.getString("temp")+"°C"
                val pressure = main.getString("pressure")
                val humidity = main.getString("humidity")+"%"
                val windSpeed = wind.getString("speed")
                val weatherDescription = weather.getString("description")

                val address = jsonObj.getString("name")+", "+sys.getString("country")

                //vypíše stav počasia na textview
                view?.findViewById<TextView>(R.id.forecast)?.text = "$address\nTemperature: $temp\nPressure: $pressure\nHumidity: $humidity\nWind speed: $windSpeed\n$weatherDescription"
            } catch (e: Exception) {
                view?.findViewById<TextView>(R.id.forecast)?.text = "Error"
            }
        }
    }

    //pri zmene lokacie pomocou openweathermap ziska informacie o pocasi
    override fun onLocationChanged(location: Location) {
        URL = "https://api.openweathermap.org/data/2.5/weather?lat=${location.latitude}&lon=${location.longitude}&units=metric&appid=$API"
        weatherTask().execute()
    }
}