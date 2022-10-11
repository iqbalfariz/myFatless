package com.izo.fatless.data.request

import com.google.gson.annotations.SerializedName

data class RequestPredict(

	@field:SerializedName("RequestPredict")
	var requestPredict: List<RequestPredictItem?>? = null
)

data class RequestPredictItem(

	@field:SerializedName("Chest")
	var chest: Double? = null,

	@field:SerializedName("Thigh")
	var thigh: Int? = null,

	@field:SerializedName("Height")
	var height: Double? = null,

	@field:SerializedName("Biceps")
	var biceps: Int? = null,

	@field:SerializedName("Density")
	var density: Double? = null,

	@field:SerializedName("Age")
	var age: Int? = null,

	@field:SerializedName("Weight")
	var weight: Double? = null,

	@field:SerializedName("Hip")
	var hip: Double? = null,

	@field:SerializedName("Abdomen")
	var abdomen: Double? = null
)
