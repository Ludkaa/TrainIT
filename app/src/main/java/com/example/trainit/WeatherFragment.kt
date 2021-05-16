package com.example.trainit

import android.annotation.SuppressLint
import android.location.Location
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
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class WeatherFragment : Fragment() {
    val API: String = "06c921750b9a82d8f5d1294e1586276f"
    var URL: String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_back).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        //premenná do ktorej sa uloží objekt
        val locationResult: MyLocation.LocationResult = object : MyLocation.LocationResult() {
            override fun gotLocation(location: Location?) {
                URL = "https://api.openweathermap.org/data/2.5/weather?lat=${location?.latitude}&lon=${location?.longitude}&units=metric&appid=$API"
                weatherTask().execute()
            }
        }
        //vytvorí sa inštancia objektu MyLocation
        val myLocation = MyLocation()
        myLocation.getLocation(context, locationResult)
    }

    //rozšírenie triedy
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
                view?.findViewById<TextView>(R.id.textview_second)?.text = "$address\nTemperature: $temp\nPressure: $pressure\nHumidity: $humidity\nWind speed: $windSpeed\n$weatherDescription"
            } catch (e: Exception) {
                view?.findViewById<TextView>(R.id.textview_second)?.text = "Error"
            }
        }
    }
}