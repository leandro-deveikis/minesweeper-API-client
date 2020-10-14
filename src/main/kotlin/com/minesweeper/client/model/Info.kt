package com.minesweeper.client.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.minesweeper.client.helper.GsonHelper

data class Info(
        val author: String,
        val repo: String,
        val projectName: String,
        val version: String
) {
    class Deserializer : ResponseDeserializable<Info> {
        override fun deserialize(content: String): Info? =
                GsonHelper.getGsonInstance().fromJson(content, Info::class.java)
    }
}