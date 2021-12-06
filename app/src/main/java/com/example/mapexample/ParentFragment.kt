package com.example.mapexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap

class ParentFragment : Fragment() {
    private lateinit var mapFragment: CustomMapFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_parent, container, false)
        mapFragment = childFragmentManager.findFragmentById(R.id.custom_map_fragment) as CustomMapFragment
        mapFragment.getMapAsync {
            mapFragment.mapReady(it)
            it.mapType = GoogleMap.MAP_TYPE_SATELLITE
        }
        return view
    }

}