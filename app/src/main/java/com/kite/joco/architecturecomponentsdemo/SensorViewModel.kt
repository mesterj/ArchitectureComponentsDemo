package com.kite.joco.architecturecomponentsdemo

import android.content.Context
import android.hardware.SensorEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class SensorViewModel: ViewModel() {

    private var accSensorLiveData: SensorLiveData? = null

    init {

    }

    fun getAcceleroLiveData(context: Context) : LiveData<SensorEvent> {
        if (accSensorLiveData == null) {
            accSensorLiveData = SensorLiveData(context)
        }
        return accSensorLiveData as SensorLiveData

    }

}