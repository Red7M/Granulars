package com.example.granulars

import java.lang.StringBuilder

object Helper {

    //RGB for color yellow
    private const val yellow = "255 255 0"
    private const val red = "255 0 0"
    private const val blank = "0 0 0"

    fun reset(count: Int, animData: String, panels: Panels): String {
        val decimals = StringBuilder("71 ")
        val appendedStr = "     "
        var xIncrement = 0
        var decimal = 300
        var xStart = 0
        var xEnd = 200
        for (c in appendedStr) {
            val matchSingleDigitOrK = matchSingleDigitOrK(c.toString(), animData, panels, xIncrement, xStart, xEnd)
            decimals.append(matchSingleDigitOrK).append(" ")
            decimals.append(appendDecimalInBetweenNum(panels, decimal, xEnd))
            xIncrement += 400
            decimal += 400
            xStart = xIncrement
            xEnd = xStart + 200
        }
        return decimals.toString()
    }

    fun loopThroughCount(count: Int, animData: String, panels: Panels): String {
        val decimals = StringBuilder(animData.substring(0, 3))
        val appendedStr = appendBlank(formatCount(count))
        var xIncrement = 0
        var decimal = 300
        var xStart = 0
        var xEnd = 200
        for (c in appendedStr) {
            val matchSingleDigitOrK = matchSingleDigitOrK(c.toString(), animData, panels, xIncrement, xStart, xEnd)
            decimals.append(matchSingleDigitOrK).append(" ")
            decimals.append(appendDecimalInBetweenNum(panels, decimal, xEnd))
            xIncrement += 400
            decimal += 400
            xStart = xIncrement
            xEnd = xStart + 200
        }
        return decimals.toString()
    }

    private fun appendDecimalInBetweenNum(panels: Panels, decimal: Int, xEnd: Int): String {
        if (decimal > 1800) return ""
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.y == 0 && (panel.x + 300 == decimal)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 20 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun matchSingleDigitOrK(
        digitStr: String,
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ) : String{
        return when (digitStr) {
            "0" -> displayZero(animData, panels, xIncrement, xStart, xEnd).trim()
            "1" -> displayOne(animData, panels, xIncrement, xStart, xEnd).trim()
            "2" -> displayTwo(animData, panels, xIncrement, xStart, xEnd).trim()
            "3" -> displayThree(animData, panels, xIncrement, xStart, xEnd).trim()
            "4" -> displayFour(animData, panels, xIncrement, xStart, xEnd).trim()
            "5" -> displayFive(animData, panels, xIncrement, xStart, xEnd).trim()
            "6" -> displaySix(animData, panels, xIncrement, xStart, xEnd).trim()
            "7" -> displaySeven(animData, panels, xIncrement, xStart, xEnd).trim()
            "8" -> displayEight(animData, panels, xIncrement, xStart, xEnd).trim()
            "9" -> displayNine(animData, panels, xIncrement, xStart, xEnd).trim()
            "k" -> displayK(animData, panels, xIncrement, xStart, xEnd).trim()
            " " -> displayBlank(animData, panels, xIncrement, xStart, xEnd).trim()
            else -> displayError(animData, panels, xIncrement, xStart, xEnd).trim()
        }
    }

    private fun appendBlank(countStr: String) : String {
        val countLength = countStr.toInt()
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

    private fun displayZero(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            if ((panel.x == 100 + xIncrement) && panel.y == 200) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayOne(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            if (panel.x != 200 + xIncrement) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayTwo(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            if (((panel.x == xIncrement) && panel.y == 300) || ((panel.x == 200 + xIncrement) && panel.y == 100)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayThree(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            if (((panel.x == xIncrement) && panel.y == 300) || ((panel.x == xIncrement) && panel.y == 100)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayFour(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            if (((panel.x == 100 + xIncrement) && panel.y == 400)
                || ((panel.x == xIncrement) && panel.y == 0)
                || ((panel.x == xIncrement) && panel.y == 100)
                || ((panel.x == 100 + xIncrement) && panel.y == 0)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayFive(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            if (((panel.x == 200 + xIncrement) && panel.y == 300) || ((panel.x == xIncrement) && panel.y == 100)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displaySix(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            if (((panel.x == 200 + xIncrement) && panel.y == 300)) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displaySeven(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            if ((panel.x == 200 + xIncrement) || panel.y == 400) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 20 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayEight(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        return zeroLayout.toString()
    }

    private fun displayNine(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            if ((panel.x == xIncrement) && panel.y == 100) {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(blank).append(" 0 5 ")
            } else {
                zeroLayout.append(panel.panelId).append(" 1 ")
                    .append(red).append(" 0 5 ")
            }
        }
        return zeroLayout.toString()
    }

    private fun displayBlank(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        val zeroLayout = StringBuilder()
        for (panel in panels.panelList!!) {
            if (panel.x !in xStart..xEnd) continue
            zeroLayout.append(panel.panelId).append(" 1 ")
                .append(blank).append(" 0 20 ")
        }
        return zeroLayout.toString()
    }

    private fun displayK(animData: String, panels: Panels, xIncrement: Int, xStart: Int, xEnd: Int): String {
        return ""
    }

    private fun displayError(
        animData: String,
        panels: Panels,
        xIncrement: Int,
        xStart: Int,
        xEnd: Int
    ): String {
        return ""
    }
}