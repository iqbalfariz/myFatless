package com.izo.fatless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.izo.fatless.data.api.ApiConfig
import com.izo.fatless.data.api.ApiService
import com.izo.fatless.data.request.RequestPredict
import com.izo.fatless.data.request.RequestPredictItem
import com.izo.fatless.data.response.PredictResponse
import com.izo.fatless.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener{
            getPredict()
        }
    }

    private fun getPredict() {
        val requestPredict = RequestPredictItem()
        val requestPredictBase = RequestPredict()

//        val age = binding.edAge.text.toString()
//        val weight = binding.edWeight.text.toString()
//        val height = binding.edHeight.text.toString()
//        val chest = binding.edChest.text.toString()
//        val abdomen = binding.edAbdomen.text.toString()
//        val hip = binding.edHip.text.toString()
//        val thigh = binding.edThigh.text.toString()
//        val biceps = binding.edBiceps.text.toString()


        val age = 25
        val weight = 154.25
        val height = 67.75
        val chest = 93.1
        val abdomen = 85.2
        val hip = 94.5
        val thigh = 59
        val biceps = 32

        requestPredict.density = 1.0708.toDouble()
        requestPredict.age = age.toInt()
        requestPredict.weight = height.toDouble()
        requestPredict.height = weight.toDouble()
        requestPredict.chest = chest.toDouble()
        requestPredict.abdomen = abdomen.toDouble()
        requestPredict.hip = hip.toDouble()
        requestPredict.thigh = thigh.toInt()
        requestPredict.biceps = biceps.toInt()

        var prediction = requestPredictBase.requestPredict
        prediction = listOf(requestPredict)

        println(requestPredict.density)
        println(requestPredict.age)
        println(requestPredict.weight)
        println(requestPredict.height)
        println(requestPredict.chest)
        println(requestPredict.abdomen)
        println(requestPredict.hip)
        println(requestPredict.thigh)
        println(requestPredict.biceps)

        println(prediction)

        val retrofit = ApiConfig().getRetrofitClientInstance().create(ApiService::class.java)
        retrofit.getPredict(prediction).enqueue(object : retrofit2.Callback<PredictResponse>{
            override fun onResponse(
                call: Call<PredictResponse>,
                response: Response<PredictResponse>
            ) {
                val responseBody = response.body()
                Log.e("Berhasil", "{${response.body().toString()}}")
                if (responseBody != null) {
                    binding.tvResultPredict.text = responseBody?.prediction.toString()
                }
            }

            override fun onFailure(call: Call<PredictResponse>, t: Throwable) {
                println("No")
            }
        })
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
