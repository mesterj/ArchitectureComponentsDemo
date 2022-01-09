package com.kite.joco.architecturecomponentsdemo

import android.hardware.SensorEvent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import com.kite.joco.architecturecomponentsdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private val sensorViewModel : SensorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //1.0
        //lifecycle.addObserver(SensorLifeCycleObserver(this))

        //2.0
       /* val acceloLiveData = SensorLiveData(this)
        acceloLiveData.observe(this,
            object : Observer<SensorEvent> {
                override fun onChanged(t: SensorEvent?) {
                    binding.tvData.text = "X: ${t!!.values[0]} Y:${t!!.values[1]} Z: ${t!!.values[2]} "
                }
            })*/

      //3.0 ViewModel
        sensorViewModel.getAcceleroLiveData(this).observe(this,
        object : Observer<SensorEvent> {
            override fun onChanged(t: SensorEvent?) {
                binding.tvData.text = "X: ${t!!.values[0]} Y:${t!!.values[1]} Z: ${t!!.values[2]} "
            }
        }
        )

    }
}