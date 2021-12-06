package com.example.mapexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomMarker(context: Context) : ConstraintLayout(context) {
    private lateinit var markerText: TextView
    private lateinit var markerImage: ImageView
    private var markerView: View
    init {
        markerView = LayoutInflater.from(context).inflate(R.layout.view_custom_marker,this,true)
        markerText = markerView.findViewById(R.id.tv_marker)
        markerImage = markerView.findViewById(R.id.iv_marker)
    }
    fun setText(string: String)
    {
        markerText.text = string
    }
}