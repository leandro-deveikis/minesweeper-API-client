package com.minesweeper.client.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.minesweeper.client.helper.GsonHelper
import java.time.LocalDateTime

data class Game(
        val id: Int,
        val player: Player,
        val grid: Array<Array<Square>>,
        val startTime: LocalDateTime,
        val finishTime: LocalDateTime?,
        val state: GameState,
        val result: GameResult?,
        val height: Int,
        val width: Int
) {
    class Deserializer : ResponseDeserializable<Game> {
        override fun deserialize(content: String): Game? =
                GsonHelper.getGsonInstance().fromJson(content, Game::class.java)
    }
}