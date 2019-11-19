package com.example.gesture

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.example.gesture.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.view.MotionEventCompat as MotionEventCompat1

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {
    //variabel untuk mendeteksi Gesture yang diberi nilai awal yaitu null
    var gDetector: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.gDetector = GestureDetectorCompat(this, this)
        //mendeteksi ketukkan ganda
        gDetector?.setOnDoubleTapListener(this)
    }

    //mencegah sentuhan/tap dan meneruskannya ke instance GestureDetectorCompat
    override fun onTouchEvent(event : MotionEvent) : Boolean {
        this.gDetector?.onTouchEvent(event)
        //mematikan untuk memanggil implementasi superclass
        return super.onTouchEvent(event)
    }
    //implemetasi untuk ketukan kebawah atau onDown
    override fun onDown (event: MotionEvent) : Boolean {
        gesture_status.text = "onDown"
        return true
    }

    //implementasi untuk ketukan melempar atau onFling
    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        gesture_status.text = "onFling"
        return true
    }
    //implementasi untuk ketukan lama atau onLongPress
    override fun onLongPress (event: MotionEvent) {
        gesture_status.text = "onLongPress"
    }
    //implementasi untuk melakukan scroll atau onScroll
    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        gesture_status.text = "onScroll"
        return true
    }
    //implementasi untuk menekan atau onShowPress
    override fun onShowPress(event: MotionEvent) {
        gesture_status.text = "ShowPress"
    }
    //implementasi untuk sekali ketuk atau onSingleTapUp
    override fun onSingleTapUp(event: MotionEvent):Boolean{
        gesture_status.text = "onSingleTapUp"
        return true
    }
    //implementasi untuk ketukan berulang dua kali atau onDoubleTap
    override fun onDoubleTap(event: MotionEvent): Boolean {
        gesture_status.text = " onDoubleTab"
        return true
    }
    //implementasi untuk ketukan berulang-ulang atau onDoubleTapEvent
    override fun onDoubleTapEvent(e: MotionEvent): Boolean {
        gesture_status.text = "onDoubleTabEvent"
        return true
    }
    //implementasi untuk satu kali ketukan dikonfirmasi atau onSingleTapConfitmed
    override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
        gesture_status.text = "onSingleTabConfirmed"
        return true
    }
}
