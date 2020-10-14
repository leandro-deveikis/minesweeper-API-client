package com.minesweeper.client

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.jsonBody
import com.minesweeper.client.model.Game
import com.minesweeper.client.model.request.ClickGameRequest
import com.minesweeper.client.model.request.CreateGameRequest
import com.minesweeper.client.model.request.FlagGameRequest

/**
 * GameClient groups the operations done for a game.
 */
abstract class GameClient {
    companion object {

        fun getGame(id: Int): Game? {
            return Fuel.get(Constants.baseUrl + "/game/$id")
                    .responseObject(Game.Deserializer())
                    .third.component1()
        }

        fun createGame(request: CreateGameRequest): Game? {
            return Fuel.post(Constants.baseUrl + "/game/")
                    .jsonBody(request)
                    .responseObject(Game.Deserializer())
                    .third.component1()
        }

        fun flag(id: Int, request: FlagGameRequest): Game? {
            return Fuel.post(Constants.baseUrl + "/game/$id/flag")
                    .jsonBody(request)
                    .responseObject(Game.Deserializer())
                    .third.component1()
        }

        fun click(id: Int, request: ClickGameRequest): Game? {
            return Fuel.post(Constants.baseUrl + "/game/$id/click")
                    .jsonBody(request)
                    .responseObject(Game.Deserializer())
                    .third.component1()
        }
    }
}
