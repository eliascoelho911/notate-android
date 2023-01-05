package com.clyo.serializer.kotlinxserialization.stub

import com.clyo.serializer.kotlinxserialization.ClyoData

internal object ScreenDataStub {

    val jsonValue = """
        {
            "content": ${LayoutDataStub.jsonValue}
        }
    """.trimIndent()

    val screenData = ClyoData(
        container = LayoutDataStub.viewData
    )
}