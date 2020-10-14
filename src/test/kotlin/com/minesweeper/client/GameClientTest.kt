package com.minesweeper.client

import com.minesweeper.client.model.FlagType
import com.minesweeper.client.model.GameState
import com.minesweeper.client.model.SquareState
import com.minesweeper.client.model.request.ClickGameRequest
import com.minesweeper.client.model.request.CreateGameRequest
import com.minesweeper.client.model.request.CreatePlayerRequest
import com.minesweeper.client.model.request.FlagGameRequest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GameClientTest {

    @Test
    fun test_createFlagAndClickGame_ok() {
        // first we need a player
        val name = "Some name"
        val player = PlayerClient.createPlayer(CreatePlayerRequest(name))
        assertNotNull(player)

        // new create the game
        val height = 5
        val width = 6
        val game1 = GameClient.createGame(CreateGameRequest(player!!.id, height, width, 10))
        assertNotNull(game1)
        assertNotNull(game1!!.id)
        assertNotNull(game1.grid)
        assertEquals(height, game1.height)
        assertEquals(width, game1.width)
        assertNotNull(game1.startTime)
        assertNull(game1.finishTime)
        assertEquals(player.id, game1.player.id)
        assertNull(game1.result)
        assertEquals(GameState.PLAYING, game1.state)

        val x1 = 1
        val y1 = 1
        val flagType = FlagType.QUESTION_MARK
        val game2 = GameClient.flag(game1.id, FlagGameRequest(x1, y1, flagType))
        assertNotNull(game2)
        assertNotNull(game2!!.id)
        assertNotNull(game2.grid)
        assertEquals(SquareState.FLAGGED, game2.grid[x1][y1].state)
        assertEquals(flagType, game2.grid[x1][y1].flagType)

        val game3 = GameClient.flag(game1.id, FlagGameRequest(x1, y1, flagType))
        assertNotNull(game3)
        assertNotNull(game3!!.id)
        assertNotNull(game3.grid)
        assertEquals(SquareState.COVERED, game3.grid[x1][y1].state)
        assertNull(game3.grid[x1][y1].flagType)

        val x2 = 1
        val y2 = 1
        val game4 = GameClient.click(game1.id, ClickGameRequest(x2, y2))
        assertNotNull(game4)
        assertNotNull(game4!!.id)
        assertNotNull(game4.grid)
        assertEquals(SquareState.UNCOVERED, game4.grid[x2][y2].state)
    }

}