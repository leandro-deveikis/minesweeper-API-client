package com.minesweeper.client.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.minesweeper.client.helper.GsonHelper

data class Player(
        val id: Int,
        val name: String) {

    class Deserializer : ResponseDeserializable<Player> {
        override fun deserialize(content: String): Player? =
                GsonHelper.getGsonInstance().fromJson(content, Player::class.java)
    }
}
