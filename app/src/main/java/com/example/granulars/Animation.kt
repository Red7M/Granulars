package com.example.granulars

import com.google.gson.annotations.SerializedName

class Animation {

    @SerializedName("command") var command : String? = null
    @SerializedName("animType") var animType : String? = null
    @SerializedName("animData") var animData : String? = null
    @SerializedName("loop") var loop : Boolean = false
    @SerializedName("palette") var palette : List<Palette>? = null
    @SerializedName("colorType") var colorType : String? = null
}