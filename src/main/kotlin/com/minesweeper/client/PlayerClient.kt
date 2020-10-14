package com.minesweeper.client

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.jsonBody
import com.minesweeper.client.model.Player
import com.minesweeper.client.model.request.CreatePlayerRequest

/**
 * PlayerClient groups the operations done for a Player.
 */
abstract class PlayerClient {
    companion object {

        fun getPlayer(id: Int): Player? {
            return Fuel.get(Constants.baseUrl + "/player/$id")
                    .responseObject(Player.Deserializer())
                    .third.component1()
        }

        fun createPlayer(request: CreatePlayerRequest): Player? {
            return Fuel.post(Constants.baseUrl + "/player/")
                    .jsonBody(request)
                    .responseObject(Player.Deserializer())
                    .third.component1()
        }
    }
}
