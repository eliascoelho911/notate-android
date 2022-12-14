package com.eliascoelho911.clyo.sample.data.repository

import com.clyo.serializer.kotlinxserialization.ClyoData
import com.eliascoelho911.clyo.sample.data.service.GetClyoSampleScreenContent
import com.eliascoelho911.clyo.sample.domain.repository.ClyoSampleRepository

internal class ClyoSampleRepositoryImpl(
    private val service: GetClyoSampleScreenContent
) : ClyoSampleRepository {
    override fun getScreenContent(): ClyoData = service()
}