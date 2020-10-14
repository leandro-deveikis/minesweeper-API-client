package com.minesweeper.client.helper

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import java.time.LocalDateTime


abstract class GsonHelper {
    companion object {
        fun getGsonInstance(): Gson {
            return GsonBuilder().registerTypeAdapter(LocalDateTime::class.java, JsonDeserializer
            { json, type, jsonDeserializationContext -> LocalDateTime.parse(json.asJsonPrimitive.asString) })
                    .create()
        }
    }
}