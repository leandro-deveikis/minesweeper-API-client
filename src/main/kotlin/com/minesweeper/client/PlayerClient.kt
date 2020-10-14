package com.minesweeper.client

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.jsonBody
import com.minesweeper.client.model.Player
import com.minesweeper.client.model.request.CreatePlayerRequest

abstract class PlayerClient {
    companion object {

        fun getPlayer(id: Int): Player? {
            return Fuel.get("http://minesweeper-api-ld.herokuapp.com/player/$id")
                    .responseObject(Player.Deserializer())
                    .third.component1()
        }

        fun createPlayer(request: CreatePlayerRequest): Player? {
            return Fuel.post("http://minesweeper-api-ld.herokuapp.com/player/")
                    .jsonBody(request)
                    .responseObject(Player.Deserializer())
                    .third.component1()
        }
    }
}
