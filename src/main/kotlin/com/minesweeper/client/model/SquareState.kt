package com.minesweeper.client.model

/**
 *
 */
enum class SquareState {
    /**
     * The player can not yet see whats on this square
     */
    COVERED,

    /**
     * The player hit this square
     */
    UNCOVERED,

    /**
     * The player flagged this square as suspected to contain a mine.
     * While the Square is flagged, can not be hit.
     */
    FLAGGED
}