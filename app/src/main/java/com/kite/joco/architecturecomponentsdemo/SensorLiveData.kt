package com.kite.joco.architecturecomponentsdemo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData

class SensorLiveData(private val context: Context) : LiveData<SensorEvent>(), SensorEventListener {

    private val sensorManager : SensorManager
    private val accSensor:  Sensor

    init {
        sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onActive() {
        super.onActive()
        sensorManager.registerListener(
            this,
            accSensor,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onInactive() {
        super.onInactive()
        sensorManager.unregisterListener(this)
        Toast.makeText(context,"INACTIVATE",Toast.LENGTH_LONG).show()
    }

    override fun onSensorChanged(event: SensorEvent?) {
        value =event
       // Toast.makeText(context,"ACTIVATED",Toast.LENGTH_LONG).show()
        Log.d("TAG SENSOR","x: ${event!!.values[0]} y: ${event!!.values[1]} Z: ${event!!.values[2]}")
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

}

