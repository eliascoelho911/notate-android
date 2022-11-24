package com.clyo.core.data.stub

import com.clyo.core.data.kotlinx.serialization.data.ComponentDataKS
import com.clyo.core.data.kotlinx.serialization.data.ComponentPropertiesKS
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

internal object ComponentDataStub {
    val jsonValue = """
        {
          "name": "component",
          "properties": {
            "value": 0,
            "array": [
              0,
              1
            ],
            "map": {
              "zero": 0
            }
          }
        }
    """.trimIndent()

    val componentDataKS = ComponentDataKS(
        name = "component",
        properties = ComponentPropertiesKS(
            JsonObject(
                mapOf(
                    "value" to JsonPrimitive(0),
                    "array" to JsonArray(
                        listOf(
                            JsonPrimitive(0),
                            JsonPrimitive(1)
                        )
                    ),
                    "map" to JsonObject(
                        mapOf(
                            "zero" to JsonPrimitive(0)
                        )
                    )
                )
            )
        )
    )
}