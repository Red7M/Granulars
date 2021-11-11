package com.example.granulars

import java.lang.StringBuilder

object Helper {

    //RGB for color yellow
    private const val yellow = "255 255 0"
    private const val red = "255 0 0"
    private const val blank = "0 0 0"

    fun loopThroughCount(count: Int, animData: String, panels: Panels) {
        val appendedStr = appendBlank(formatCount(count))
        for (c in appendedStr) {
            matchSingleDigitOrK(c.toString(), animData, panels)
        }
    }

    private fun appendBlank(countStr: String) : String {
        val countLength = countStr.length
        if (countLength < 10) {
            return "    $countStr"
        } else if (countLength < 100) {
            return "   $countStr"
        } else if (countLength < 1000) {
            return "  $countStr"
        } else if (countLength < 10000) {
            return " $countStr"
        } else {
            return countStr
        }
    }

    private fun formatCount(count: Int): String {
        return if (isGreaterThan100k(count) && isLessThan1M(count)) {
             (count / 1000).toString() + "k"
        } else if (!isLessThan1M(count)) {
            "e"
        } else {
            count.toString()
        }
    }

    private fun isGreaterThan100k(count: Int) : Boolean{
        return count > 99999
    }

    private fun isLessThan1M(count: Int) : Boolean {
        return count < 1000000
    }

    fun matchSingleDigitOrK(digitStr: String, animData: String, panels: Panels) : String{
        return when (digitStr) {
            "0" -> displayZero(animData, panels)
            "1" -> displayOne(animData, panels)
            "2" -> displayTwo(animData, panels)
            "3" -> displayThree(animData, panels)
            "4" -> displayFour(animData, panels)
            "5" -> displayFive(animData, panels)
            "6" -> displaySix(animData, panels)
            "7" -> displaySeven(animData, panels)
            "8" -> displayEight(animData, panels)
            "9" -> displayNine(animData, panels)
            "k" -> displayK(animData, panels)
            else -> displayError(animData, panels)
        }
    }


    private fun displayZero(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            if (panel.x == 100 && panel.y == 200) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayOne(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            if (panel.x != 200) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayTwo(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            if ((panel.x == 0 && panel.y == 300) || (panel.x == 200 && panel.y == 100)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayThree(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            if ((panel.x == 0 && panel.y == 300) || (panel.x == 0 && panel.y == 100)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayFour(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            if ((panel.x == 100 && panel.y == 400)
                || (panel.x == 0 && panel.y == 0)
                || (panel.x == 0 && panel.y == 100)
                || (panel.x == 100 && panel.y == 0)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayFive(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            if ((panel.x == 200 && panel.y == 300) || (panel.x == 0 && panel.y == 100)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displaySix(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            if ((panel.x == 200 && panel.y == 300)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displaySeven(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            if (panel.x == 200 || panel.y == 400) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 20 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayEight(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        return zeroLayout.toString()
    }

    private fun displayNine(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            if (panel.x == 0 && panel.y == 100) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayBlank(animData: String, panels: Panels): String {
        val zeroLayout = StringBuilder(animData.substring(0, 3))
        for (panel in panels.panelList!!) {
            zeroLayout.append(panel.panelId).append(" 1 ")
                .append(blank).append(" 0 20 ")
        }
        return zeroLayout.toString()
    }

    private fun displayK(animData: String, panels: Panels): String {
        return ""
    }

    private fun displayError(animData: String, panels: Panels): String {
        return ""
    }
}