package com.minesweeper.client

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.jsonBody
import com.minesweeper.client.model.Game
import com.minesweeper.client.model.request.ClickGameRequest
import com.minesweeper.client.model.request.CreateGameRequest
import com.minesweeper.client.model.request.FlagGameRequest


abstract class GameClient {
    companion object {
        fun getGame(id: Int): Game? {
            return Fuel.get("http://minesweeper-api-ld.herokuapp.com/game/$id")
                    .responseObject(Game.Deserializer())
                    .third.component1()
        }

        fun createGame(request: CreateGameRequest): Game? {
            return Fuel.post("http://minesweeper-api-ld.herokuapp.com/game/")
                    .jsonBody(request)
                    .responseObject(Game.Deserializer())
                    .third.component1()
        }

        fun flag(id: Int, request: FlagGameRequest): Game? {
            return Fuel.post("http://minesweeper-api-ld.herokuapp.com/game/$id/flag")
                    .jsonBody(request)
                    .responseObject(Game.Deserializer())
                    .third.component1()
        }

        fun click(id: Int, request: ClickGameRequest): Game? {
            return Fuel.post("http://minesweeper-api-ld.herokuapp.com/game/$id/click")
                    .jsonBody(request)
                    .responseObject(Game.Deserializer())
                    .third.component1()
        }
    }
}
