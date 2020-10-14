package com.minesweeper.client.model

data class Square(
        val state: SquareState,
        val value: SquareValue,
        val number: Int?,
        val flagType: FlagType?
)