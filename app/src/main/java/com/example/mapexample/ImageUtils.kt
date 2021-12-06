package com.example.mapexample

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ImageUtils {
    companion object {
        private val voltLinesLatLng = LatLng(41.0919773, 29.0009594)
        fun getBitmapFromView(view: View): Bitmap {
            view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
            view.layout(0, 0, view.measuredWidth, view.measuredHeight)
            view.buildDrawingCache()
            val returnedBitmap = Bitmap.createBitmap(
                view.measuredWidth, view.measuredHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(returnedBitmap)
            canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN)
            val drawable = view.background
            drawable?.draw(canvas)
            view.draw(canvas)
            return returnedBitmap
        }

        fun getBitmapFromDrawable(res : Int, context:Context):Bitmap{
            val drawable = ContextCompat.getDrawable(context,res)
            val bitmap = Bitmap.createBitmap(
                drawable!!.getIntrinsicWidth(),
                drawable!!.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas()
            canvas.setBitmap(bitmap)
            drawable.setBounds(
                0,
                0,
                canvas.width,
                canvas.height
            )
            drawable.draw(canvas)
            return bitmap
        }

        fun generateMarkerOptionsWithDrawable(context: Context):MarkerOptions{
            val markerOptions = MarkerOptions().position(voltLinesLatLng)
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromDrawable(R.drawable.ic_trip_card_bus_location,context)))
                .title("Volt Lines Ofisi")
            return markerOptions
        }

        fun generateMarkerOptionsWithView(context: Context):MarkerOptions{
            val custemMarker = CustomMarker(context)
            custemMarker.setText("9")
            val markerOptions = MarkerOptions().position(voltLinesLatLng)
                .icon(BitmapDescriptorFactory.fromBitmap(getBitmapFromView(custemMarker)))
                .title("Volt Lines Ofisi")
            return markerOptions
        }
    }
}