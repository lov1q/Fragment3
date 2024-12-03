package com.example.fragment3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), FirstFragment.FirstFragmentReceiver, SecondFragment.SecondFragmentReceiver {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun firstReceive(data: String){
        val secondFragment = supportFragmentManager.findFragmentById(R.id.fragment_second) as SecondFragment
        secondFragment.dataReceived(data)
    }
    override fun secondReceive(data: String){
        val firstFragment = supportFragmentManager.findFragmentById(R.id.fragment_first) as FirstFragment
        firstFragment.dataReceived(data)
    }
}