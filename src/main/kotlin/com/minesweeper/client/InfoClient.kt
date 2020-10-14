package com.minesweeper.client

import com.github.kittinunf.fuel.Fuel
import com.minesweeper.client.model.Info

/**
 * Information about the version of the deployed app
 */
abstract class InfoClient {
    companion object {

        fun getInfo(): Info? {
            return Fuel.get(Constants.baseUrl)
                    .responseObject(Info.Deserializer())
                    .third.component1()
        }
    }
}
