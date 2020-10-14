package com.minesweeper.client

import com.minesweeper.client.model.request.CreatePlayerRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class PlayerClientTest {

    @Test
    fun test_crateAndGetPlayer_ok() {
        val name = "Some name"
        val responseCreate = PlayerClient.createPlayer(CreatePlayerRequest(name))
        assertNotNull(responseCreate)
        assertNotNull(responseCreate?.id)
        assertEquals(name, responseCreate?.name)

        val responseGet = PlayerClient.getPlayer(responseCreate!!.id)
        assertNotNull(responseGet)
        assertNotNull(responseGet?.id)
        assertEquals(name, responseGet?.name)
    }
}