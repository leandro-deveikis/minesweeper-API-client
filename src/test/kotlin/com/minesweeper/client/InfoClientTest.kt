package com.minesweeper.client

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test


internal class InfoClientTest {

    @Test
    fun test_getInfo_ok() {
        val response = InfoClient.getInfo()
        assertNotNull(response)
        assertEquals("Leandro Deveikis <leandro.deveikis@gmail.com>", response?.author)
        assertEquals("1.0.0", response?.version)
        assertEquals("Minesweeper-API", response?.projectName)
        assertEquals("https://github.com/leandro-deveikis/minesweeper-API", response?.repo)
    }
}