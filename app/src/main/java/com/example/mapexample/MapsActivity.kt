package com.example.mapexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mapexample.databinding.ActivityMapsBinding
import com.google.android.gms.maps.*
import java.util.*
import kotlin.collections.ArrayList

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var mapFragment: CustomMapFragment
    private val polyLine =
        "iwtyFo{{oDU]YsAs@iCa@eBe@uB]kAM[g@}@o@k@}@k@e@U_@UWQiAe@aAOu@GU@q@BiB@qADwA?QBUQOIk@EcAQi@R]ZC@MNKRY~@Mf@g@u@QWcAgAOOWb@MP}@nA}@jAGHAGGEKG]Kk@UIIZoABQDOB_@Gk@@SN]J]?I?Cc@S[OaAg@m@]p@gCl@kCDOmA_B}@_Bk@s@t@oAI_@_@m@QPORe@l@UTo@lASp@c@t@M^S^_@n@Q\\\\i@vA]lAQp@a@jAQTONSNUHWDkBJa@BMDg@XMLyAbC{C~E[b@aBzA}BfBc@d@q@r@w@dA_@RQTMNkAjAa@f@WPQ@ICIIMACBaAyAk@_AoAi@cBUUCW@ODWTS|@QpH?b@BXBN`@j@`An@fApAzBvCbB|Bt@r@h@b@z@j@rE~Cj@Z`A\\\\nAX~ATLB\\\\Aj@OT[LY@QEw@Ma@iAuA`@[JCNJt@z@LPXc@?E\\"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as CustomMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mapFragment.mapReady(mMap)
        mMap.uiSettings.isCompassEnabled = true
        mMap.isTrafficEnabled = false
        //mMap.moveCamera(CameraUpdateFactory.zoomTo(12F))
        val list = arrayOf(
            LatLng(41.0919773, 29.0009594),
            LatLng(41.0920313, 29.0030912),
            LatLng(41.0916886, 29.0032997),
            LatLng(41.0910509, 29.0031327),
            LatLng(41.0886137,29.0024575)
        ).asList()
        //mapFragment.addPolyLine(list)
        //mapFragment.polyLineBounds(list)
        mapFragment.addMapMarker(ImageUtils.generateMarkerOptionsWithView(this))
        //mapFragment.addMapMarker(ImageUtils.generateMarkerOptionsWithDrawable(this))
    }
}