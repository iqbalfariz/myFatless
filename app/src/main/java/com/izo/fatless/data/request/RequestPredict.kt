package com.izo.fatless.data.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RequestPredict {

    @SerializedName("density")
    @Expose
    var density: Float? = null

    @SerializedName("age")
    @Expose
    var age: Int? = null

    @SerializedName("weight")
    @Expose
    var weight: Float? = null

    @SerializedName("height")
    @Expose
    var height: Float? = null

    @SerializedName("chest")
    @Expose
    var chest: Float? = null

    @SerializedName("abdomen")
    @Expose
    var abdomen: Float? = null

    @SerializedName("hip")
    @Expose
    var hip: Float? = null

    @SerializedName("thigh")
    @Expose
    var thigh: Int? = null

    @SerializedName("biceps")
    @Expose
    var biceps: Int? = null

}