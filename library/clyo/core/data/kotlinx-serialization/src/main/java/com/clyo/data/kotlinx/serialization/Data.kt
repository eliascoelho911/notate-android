package com.clyo.data.kotlinx.serialization

import com.clyo.data.ViewName
import com.clyo.data.kotlinx.serialization.serializer.ViewPropertiesAsJsonObjectSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.floatOrNull
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.longOrNull
import com.clyo.data.ScreenData as ScreenDataContract
import com.clyo.data.ViewData as ViewDataContract
import com.clyo.data.ViewProperties as ViewPropertiesContract

@Serializable
data class ScreenData(
    @SerialName("content")
    override val content: ViewDataContract
) : ScreenDataContract

@Serializable
data class ViewData(
    @SerialName("name")
    override val name: ViewName,
    @SerialName("properties")
    override val properties: ViewPropertiesContract = ViewProperties(JsonObject(mapOf())),
    @SerialName("content")
    override val content: List<ViewDataContract> = emptyList()
) : ViewDataContract


@Serializable(with = ViewPropertiesAsJsonObjectSerializer::class)
data class ViewProperties(
    val jsonObject: JsonObject
) : ViewPropertiesContract {
    override fun getStringOrNull(key: String): String? = get(key)?.contentOrNull

    override fun getBooleanOrNull(key: String): Boolean? = get(key)?.booleanOrNull

    override fun getDoubleOrNull(key: String): Double? = get(key)?.doubleOrNull

    override fun getFloatOrNull(key: String): Float? = get(key)?.floatOrNull

    override fun getIntOrNull(key: String): Int? = get(key)?.intOrNull

    override fun getLongOrNull(key: String): Long? = get(key)?.longOrNull

    private fun get(key: String) = jsonObject[key]?.jsonPrimitive
}