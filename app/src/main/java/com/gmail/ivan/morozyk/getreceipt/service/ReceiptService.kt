package com.gmail.ivan.morozyk.getreceipt.service

import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.awaitResult
import com.github.kittinunf.fuel.moshi.moshiDeserializerOf
import com.gmail.ivan.morozyk.getreceipt.GetReceipt
import com.gmail.ivan.morozyk.getreceipt.dto.*
import com.gmail.ivan.morozyk.getreceipt.exception.ApiRequestException

interface ReceiptService {

    suspend fun getReceipt(receiptId: String): ReceiptDto

    suspend fun getReceiptList(query: String? = null) : ReceiptListDto
}

internal class ReceiptServiceImpl: ReceiptService {

    override suspend fun getReceipt(receiptId: String): ReceiptDto {
        val parameters = mutableListOf("apiKey" to GetReceipt.apiKey)
        val requestResult = Fuel.get("recipes/${receiptId}/information/", parameters).awaitResult(
            moshiDeserializerOf(ReceiptDto::class.java)
        )

        Log.d("TAG", "getReceipt: $requestResult")

        return requestResult.fold(success = {
            it
        }, failure = {
            throw ApiRequestException(it.message!!)
        })
    }

    override suspend fun getReceiptList(query: String?): ReceiptListDto {
        val parameters = mutableListOf("apiKey" to GetReceipt.apiKey)

        if (!query.isNullOrEmpty()) {
            parameters.add("query" to query)
        }

        val requestResult = Fuel.get("https://api.spoonacular.com/recipes/complexSearch/", parameters).awaitResult(
            moshiDeserializerOf(ReceiptListDto::class.java)
        )

        Log.d("TAG", "getReceiptList: $requestResult")

        return requestResult.fold(success = {
            it
        }, failure = {
            throw ApiRequestException(it.message!!)
        })
    }
}