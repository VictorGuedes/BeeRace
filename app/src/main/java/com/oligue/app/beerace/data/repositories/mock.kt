package com.oligue.app.beerace.data.repositories

import com.oligue.app.beerace.ui.base.model.BeeUI
import com.oligue.app.beerace.ui.base.model.WinnerUI

val mockBeeList = mutableListOf(
    BeeUI(name = "BeeStouri", color = "#183da3", positionString = "1 st", position = 1),
    BeeUI(name = "BeeM", color = "#d68b6b", positionString = "2 nd", position = 2),
    BeeUI(name = "BeeAman", color = "#8a18a3", positionString = "3 th", position = 3),
    BeeUI(name = "Beech", color = "#464247", positionString = "3 th", position = 4),
    BeeUI(name = "BeeCome", color = "#6bcad6", positionString = "3 th", position = 5),
)

val winner = WinnerUI(beeName = "hamilton", color = "#183da3")