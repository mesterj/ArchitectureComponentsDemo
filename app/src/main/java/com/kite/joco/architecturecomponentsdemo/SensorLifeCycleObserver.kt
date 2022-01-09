package com.kite.joco.architecturecomponentsdemo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class SensorLifeCycleObserver(private val context: Context) : LifecycleObserver, SensorEventListener {

    private val sensorManager : SensorManager
    private val accSensor:  Sensor

    init {
        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startSensorMonitroing() {
        sensorManager.registerListener(this,accSensor,SensorManager.SENSOR_DELAY_GAME)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopSensorMonitoring() {
        sensorManager.unregisterListener(this)
    }


    override fun onSensorChanged(p0: SensorEvent?) {
        Log.d("TAG SENSOR","x: ${p0!!.values[0]} y: ${p0!!.values[1]} Z: ${p0!!.values[2]}")
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}