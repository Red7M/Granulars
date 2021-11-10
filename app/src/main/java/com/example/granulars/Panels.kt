package com.example.granulars

import com.google.gson.annotations.SerializedName

open class Panels {
    var numPanels : Int = 0
    var sideLength : Int = 0
    @SerializedName("positionData")
    var panelList : List<Panel>? = null
}