package com.izo.fatless

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import com.izo.fatless.data.api.ApiConfig
import com.izo.fatless.data.request.RequestPredict
import com.izo.fatless.data.response.PredictResponse
import com.izo.fatless.databinding.ActivityMainBinding
import okhttp3.internal.userAgent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestPredict = RequestPredict()

        val age = binding.edAge.text.toString()
        val weight = binding.edWeight.text.toString()
        val height = binding.edHeight.text.toString()
        val chest = binding.edChest.text.toString()
        val abdomen = binding.edAbdomen.text.toString()
        val hip = binding.edHip.text.toString()
        val thigh = binding.edThigh.text.toString()
        val biceps = binding.edBiceps.text.toString()

        requestPredict.density = 1.0708.toFloat()
        requestPredict.age = age.toInt()
        requestPredict.weight = height.toFloat()
        requestPredict.height = weight.toFloat()
        requestPredict.chest = chest.toFloat()
        requestPredict.abdomen = abdomen.toFloat()
        requestPredict.hip = hip.toFloat()
        requestPredict.thigh = thigh.toInt()
        requestPredict.biceps = biceps.toInt()


        binding.button.setOnClickListener{
            getPredict(requestPredict)
        }
    }

    private fun getPredict(requestPredict: RequestPredict) {
        val client = ApiConfig.getApiService().getPredict(requestPredict)
        client.enqueue(object : Callback<PredictResponse> {
            override fun onResponse(
                call: Call<PredictResponse>,
                response: Response<PredictResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        binding.tvResultPredict.text = responseBody.resultProduct.toString()
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<PredictResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
