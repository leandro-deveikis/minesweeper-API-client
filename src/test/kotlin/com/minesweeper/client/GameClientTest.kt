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
        val createGameResponse = GameClient.createGame(CreateGameRequest(player!!.id, height, width, 10))
        assertNotNull(createGameResponse)
        assertNotNull(createGameResponse!!.id)
        assertNotNull(createGameResponse.grid)
        assertEquals(height, createGameResponse.height)
        assertEquals(width, createGameResponse.width)
        assertNotNull(createGameResponse.startTime)
        assertNull(createGameResponse.finishTime)
        assertEquals(player.id, createGameResponse.player.id)
        assertNull(createGameResponse.result)
        assertEquals(GameState.PLAYING, createGameResponse.state)

        val getGameResponse = GameClient.getGame(createGameResponse.id)
        assertNotNull(getGameResponse)
        assertNotNull(getGameResponse!!.id)

        val x1 = 1
        val y1 = 1
        val flagType = FlagType.QUESTION_MARK
        val flagResponse1 = GameClient.flag(createGameResponse.id, FlagGameRequest(x1, y1, flagType))
        assertNotNull(flagResponse1)
        assertNotNull(flagResponse1!!.id)
        assertNotNull(flagResponse1.grid)
        assertEquals(SquareState.FLAGGED, flagResponse1.grid[x1][y1].state)
        assertEquals(flagType, flagResponse1.grid[x1][y1].flagType)

        val flagResponse2 = GameClient.flag(createGameResponse.id, FlagGameRequest(x1, y1, flagType))
        assertNotNull(flagResponse2)
        assertNotNull(flagResponse2!!.id)
        assertNotNull(flagResponse2.grid)
        assertEquals(SquareState.COVERED, flagResponse2.grid[x1][y1].state)
        assertNull(flagResponse2.grid[x1][y1].flagType)

        val x2 = 1
        val y2 = 1
        val clickResponse = GameClient.click(createGameResponse.id, ClickGameRequest(x2, y2))
        assertNotNull(clickResponse)
        assertNotNull(clickResponse!!.id)
        assertNotNull(clickResponse.grid)
        assertEquals(SquareState.UNCOVERED, clickResponse.grid[x2][y2].state)
    }

}