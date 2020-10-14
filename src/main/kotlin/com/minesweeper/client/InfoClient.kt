package com.minesweeper.client

import com.github.kittinunf.fuel.Fuel
import com.minesweeper.client.model.Info

abstract class InfoClient {
    companion object {
        fun getInfo(): Info? {
            return Fuel.get("http://minesweeper-api-ld.herokuapp.com/")
                    .responseObject(Info.Deserializer())
                    .third.component1()
        }
    }
}
