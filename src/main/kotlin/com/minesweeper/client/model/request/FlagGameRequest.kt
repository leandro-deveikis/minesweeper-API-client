package com.minesweeper.client.model.request

import com.minesweeper.client.model.FlagType

data class FlagGameRequest(
        val x: Int,
        val y: Int,
        val flagType: FlagType
)