package com.example.mapexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentHolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_holder)
        val transaction =  supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,ParentFragment()).commit()
    }
}