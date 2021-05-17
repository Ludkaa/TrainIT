package com.example.trainit

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.maps.android.SphericalUtil
import kotlin.math.round


class MapsFragment : Fragment(), OnMapReadyCallback, LocationListener {
    private var mMap: GoogleMap? = null
    private lateinit var locationManager: LocationManager
    private val polylineOptions = PolylineOptions().clickable(true)
    private var mCurrLocationMarker : Marker? = null
    private var MillisecondTime: Long = 0
    private var StartTime: Long = 0
    private var StartPauseTime: Long = 0
    private var TimeBuff: Long = 0
    private var UpdateTime = 0L
    private var Seconds: Int = 0
    private var Minutes: Int = 0
    private var Hours: Int = 0
    private var MilliSeconds: Int = 0
    private var handler: Handler? = null
    private var flag:Boolean=false
    private var Time: TextView? = null
    private var Distance: TextView? = null
    private var Speed: TextView? = null
    private val mLatLngList: ArrayList<LatLng> = ArrayList()
    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationChannel: NotificationChannel
    private lateinit var builder: Notification.Builder
    private val channelId = "com.example.trainit.notify"

    //vytvorenie mapy
    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap
        getLocation()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_maps, container, false)
        Time = root.findViewById(R.id.time)
        Distance = root.findViewById(R.id.distance)
        Speed = root.findViewById(R.id.speed)
        notificationManager = requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        handler = Handler()
        val pauseButton = root.findViewById<FloatingActionButton>(R.id.pause_button)
        val stopButton = root.findViewById<FloatingActionButton>(R.id.stop_button)
        StartTime = SystemClock.uptimeMillis()
        flag=true
        handler?.postDelayed(runnable, 0)
        pauseButton.setOnClickListener{
            if (flag){
                handler?.removeCallbacks(runnable)
                pauseButton.setImageResource(android.R.drawable.ic_media_play)
                flag=false
                StartPauseTime = SystemClock.uptimeMillis()

            }else{
                TimeBuff = SystemClock.uptimeMillis() - StartPauseTime
                pauseButton.setImageResource(android.R.drawable.ic_media_pause)
                handler?.postDelayed(runnable, 0)
                flag=true
            }
        }
        stopButton.setOnClickListener{
            handler?.removeCallbacks(runnable)
            flag=false

            //nove androidy O+(Android 8)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel = NotificationChannel(channelId, "notification", NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(root.context, channelId)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(getString(R.string.notificationP1))
                    .setContentText("Your run was ${round((SphericalUtil.computeLength(mLatLngList) / 10))/100} km long.")
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
            }
            //stare androidy N-
            else {
                builder = Notification.Builder(root.context)
                    .setContentTitle(getString(R.string.notificationP1))
                    .setContentText("Your run was ${round((SphericalUtil.computeLength(mLatLngList) / 10))/100} km long.")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
            }
            notificationManager.notify(1234, builder.build())
            findNavController().navigate(R.id.action_MapsFragment_to_MenuFragment)
        }
        return root
    }

    private fun setupMapIfNeeded() {
        if (mMap == null) {
            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
            mapFragment?.getMapAsync(this)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMapIfNeeded()
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        locationManager = (requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager)
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 5f, this)
    }
    override fun onLocationChanged(location: Location) {
        if (flag) {
            val pos = LatLng(location.latitude, location.longitude)
            mLatLngList.add(pos)
            if (mCurrLocationMarker != null) {
                mCurrLocationMarker?.position = pos
            } else {
                mCurrLocationMarker = mMap?.addMarker(
                    MarkerOptions().position(pos).title("Run")
                )
            }
            mMap?.addPolyline(polylineOptions.add(pos))
            mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 15.0f))
            Distance?.text = "${round((SphericalUtil.computeLength(mLatLngList) / 10))/100} km"
            var speedSec = ((UpdateTime/1000.0)/(SphericalUtil.computeLength(mLatLngList)/1000)).toInt()
            val speedMin = speedSec / 60
            speedSec %= 60
            if (speedSec.toString().length < 2) {
                Speed?.text = "$speedMin:0$speedSec min/km"
            } else {
                Speed?.text = "$speedMin:$speedSec min/km"
        }
            if (speedMin > 60) {
                Speed?.text = "--:-- min/km"
            }
        }
    }

    var runnable: Runnable = object : Runnable {

        override fun run() {
            MillisecondTime = SystemClock.uptimeMillis() - StartTime
            UpdateTime = MillisecondTime - TimeBuff
            Seconds = (UpdateTime / 1000).toInt()
            Hours = Seconds / 3600
            Minutes = Seconds / 60
            Seconds %= 60
            MilliSeconds = (UpdateTime % 1000).toInt()
            var minute = ""
            var seconds = ""

            if (Minutes.toString().length < 2) {
                minute = "0$Minutes"
            } else {
                minute = Minutes.toString()
            }
            if (Seconds.toString().length < 2) {
                seconds = "0$Seconds"
            } else {
                seconds = Seconds.toString()
            }
            Time?.text = "$Hours:$minute:$seconds:${MilliSeconds.toString()[0]}"
            handler?.postDelayed(this, 0)
        }

    }

}