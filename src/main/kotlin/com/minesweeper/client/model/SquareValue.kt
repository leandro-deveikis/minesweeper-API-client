package com.minesweeper.client.model

/**
 *
 */
enum class SquareValue {
    /**
     * A mine is planted at this square, so the player looses if it hits it.
     */
    MINE,

    /**
     * This is adjacent to one or more mines
     */
    NUMBER
}