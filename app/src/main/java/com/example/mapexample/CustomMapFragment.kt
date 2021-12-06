package com.example.mapexample

import android.content.Context
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class CustomMapFragment : SupportMapFragment(), CustomMapView {
    private lateinit var googleMap: GoogleMap
    private var mContext: Context? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun mapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        this.googleMap.isTrafficEnabled = true
        this.googleMap.uiSettings.isCompassEnabled = false
        val voltLinesLatLng = LatLng(41.0919773, 29.0009594)
        // default marker usage
       /* this.googleMap.addMarker(
            MarkerOptions().position(voltLinesLatLng).title("Volt Lines Ofisi")
        )
        */
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(voltLinesLatLng, 17F))
    }

    override fun addPolyLine(coordinates: List<LatLng>) {
        mContext?.let {
            googleMap.addPolyline(PolylineOptions()
                .addAll(coordinates)
                .color(ContextCompat.getColor(it,R.color.orange))
                .width(20F))
        }
        /*
        you can also use it like this with add()
        mContext?.let {
            googleMap.addPolyline(PolylineOptions()
                .add(LatLng(41.0919773, 29.0009594),
                    LatLng(41.0920313, 29.0030912),
                    LatLng(41.0916886, 29.0032997),
                    LatLng(41.0910509, 29.0031327),
                    LatLng(41.0886137,29.0024575))
                .color(ContextCompat.getColor(it,R.color.orange))
                .width(20F))
        }
         */
    }

    override fun polyLineBounds(coordinates: List<LatLng>) {
        val boundsBuilder = LatLngBounds.Builder()
        for (latLngPoint in coordinates) {
            boundsBuilder.include(latLngPoint)
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 70))
    }

    //custom marker usage
    override fun addMapMarker(markerOptions: MarkerOptions) {
        googleMap.addMarker(markerOptions)
    }

    override fun onDetach() {
        super.onDetach()
        mContext = null
    }
}