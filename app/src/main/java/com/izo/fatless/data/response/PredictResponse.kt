package com.izo.fatless.data.response

import com.google.gson.annotations.SerializedName

data class PredictResponse(
    @field:SerializedName("resultPredict")
    val resultProduct: Float? = null
)
