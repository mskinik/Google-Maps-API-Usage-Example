package com.example.mapexample

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

interface CustomMapView {
    fun mapReady(googleMap: GoogleMap)
    fun addPolyLine(coordinates: List<LatLng>)
    fun polyLineBounds(coordinates: List<LatLng>)
    fun addMapMarker(markerOptions: MarkerOptions)
}