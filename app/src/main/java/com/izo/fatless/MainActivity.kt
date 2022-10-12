package com.izo.fatless

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.izo.fatless.data.api.ApiConfig
import com.izo.fatless.data.api.ApiService
import com.izo.fatless.data.preferences.DataPref
import com.izo.fatless.data.request.RequestPredict
import com.izo.fatless.data.response.PredictResponse
import com.izo.fatless.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    lateinit var sharedPref: SharedPreferences
    private lateinit var dataPref: DataPref

    val PREF_NAME = "DATA_USER"
    val KEY_GENDER = "key.gender"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        dataPref = DataPref(this)

        var gender : String? = sharedPref.getString(KEY_GENDER, null)
        var test = "test"

        Log.e("Gender", gender.toString())


        binding.button.setOnClickListener{
            getPredict()
        }
    }

    private fun getPredict() {

        val requestPredictItem = RequestPredict.RequestPredictItem(0.0,0,0.0,
            0.0,0.0,0.0,0.0,0.0,0.0)

//        val age = binding.edAge.text.toString()
//        val weight = binding.edWeight.text.toString()
//        val height = binding.edHeight.text.toString()
//        val chest = binding.edChest.text.toString()
//        val abdomen = binding.edAbdomen.text.toString()
//        val hip = binding.edHip.text.toString()
//        val thigh = binding.edThigh.text.toString()
//        val biceps = binding.edBiceps.text.toString()

        val density = 93.1 //Chest
        val age = 23 //Age
        val weight = 32.0 //Biceps
        val height = 85.2 //Abdomen
        val chest = 67.75 //Height
        val abdomen = 1.0708 //Density
        val hip = 94.5 //Hip
        val thigh = 59.0 //Thight
        val biceps = 154.25 //Weight

        requestPredictItem.Density = density.toDouble()
        requestPredictItem.Age = age.toInt()
        requestPredictItem.Height = height.toDouble()
        requestPredictItem.Weight = weight.toDouble()
        requestPredictItem.Chest = chest.toDouble()
        requestPredictItem.Abdomen = abdomen.toDouble()
        requestPredictItem.Hip = hip.toDouble()
        requestPredictItem.Thigh = thigh.toDouble()
        requestPredictItem.Biceps = biceps.toDouble()

        Log.e("Test", requestPredictItem.toString())
        val requestPredict = RequestPredict()
        requestPredict.add(requestPredictItem)


        val retrofit = ApiConfig().getRetrofitClientInstance().create(ApiService::class.java)
        retrofit.getPredict(requestPredict).enqueue(object : retrofit2.Callback<PredictResponse>{
            override fun onResponse(
                call: Call<PredictResponse>,
                response: Response<PredictResponse>
            ) {
                val responseBody = response.body()
                val prediction = responseBody?.prediction
                Log.e("Berhasil", "{${prediction.toString()}}")
                if (responseBody != null) {
                    binding.tvResultPredict.text = prediction.toString()
                }
            }

            override fun onFailure(call: Call<PredictResponse>, t: Throwable) {
                println("No")
            }
        })
    }

    companion object {
        lateinit var requestPredict: RequestPredict
        lateinit var requestPredictItem: RequestPredict.RequestPredictItem
        const val TAG = "MainActivity"
    }
}
