package com.example.granulars

import com.google.gson.annotations.SerializedName

class Palette {
    @SerializedName("hue") var hue : Int = 0
    @SerializedName("saturation") var saturation = 0
    @SerializedName("brightness") var brightness = 0
}