package com.example.gesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{


    // variabel untuk mendeteksi Gesture yang diberi nilai awal yaitu null var gDetector:
    var gDetector:GestureDetectorCompat?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // membuat class turunan GestureDetectorCompat
        this.gDetector= GestureDetectorCompat(this,this)
        // mendeteksi ketukan ganda
        gDetector?.setOnDoubleTapListener(this)
    }

    //mencegah sentuhan/tap dan meneruskannya ke instance GestureDetectorCompat
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gDetector?.onTouchEvent(event)
        //memastikan untuk memanggil implementasi superclass
        return super.onTouchEvent(event)
    }
    //implementasi untuk ketukan kebawah atau onDown
    override fun onDown(event: MotionEvent): Boolean {
        gesture_status.text= "onDown"
        return true
    }
    //implementasi untuk ketukan melempar atau onFling
    override fun onFling(event1: MotionEvent?, event2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        gesture_status.text = "onFling"
        return true
    }
    //implementasi untuk ketukan lama atau onLongPress
    override fun onLongPress(event: MotionEvent) {
        gesture_status.text = "onLongPress"
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
    gesture_status.text = "onScroll"
        return true
    }

    override fun onShowPress(event: MotionEvent?) {
        gesture_status.text = "onShowpress"
    }

    override fun onSingleTapUp(e1: MotionEvent): Boolean{
        gesture_status.text = "onSingleTapUp"
        return true
    }

    override fun onDoubleTap(e1: MotionEvent): Boolean {
        gesture_status.text = "onDoubleTap"
        return true
    }

    override fun onDoubleTapEvent(e1: MotionEvent): Boolean {
        gesture_status.text = "onDoubleTapEvent"
        return true
    }

    override fun onSingleTapConfirmed(e1: MotionEvent): Boolean {
        gesture_status.text = "onSingleTapConfirmed"
        return true
    }

    }
