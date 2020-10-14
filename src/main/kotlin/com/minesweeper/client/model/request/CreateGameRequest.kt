package com.minesweeper.client.model.request

data class CreateGameRequest(
        val playerId: Int,
        val height: Int,
        val width: Int,
        val mineQuantity: Int
)