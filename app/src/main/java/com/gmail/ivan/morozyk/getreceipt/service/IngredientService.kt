package com.gmail.ivan.morozyk.getreceipt.service

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.awaitResult
import com.github.kittinunf.fuel.moshi.moshiDeserializerOf
import com.gmail.ivan.morozyk.getreceipt.GetReceipt
import com.gmail.ivan.morozyk.getreceipt.dto.IngredientDto
import com.gmail.ivan.morozyk.getreceipt.dto.IngredientListDto
import com.gmail.ivan.morozyk.getreceipt.exception.ApiRequestException

interface IngredientService {
    suspend fun getIngredientList(query: String) : IngredientListDto

    suspend fun getIngredient(ingredientId: String) : IngredientDto
}

internal class IngredientServiceImpl : IngredientService {
    override suspend fun getIngredientList(query: String): IngredientListDto {
        val parameters = mutableListOf("apiKey" to GetReceipt.apiKey)

        parameters.add("query" to query)

        val requestResult = Fuel.get("food/ingredients/search/", parameters).awaitResult(
            moshiDeserializerOf(IngredientListDto::class.java)
        )

        return requestResult.fold(success = {
            it
        }, failure = {
            throw ApiRequestException(it.message!!)
        })
    }

    override suspend fun getIngredient(ingredientId: String): IngredientDto {
        val parameters = mutableListOf("apiKey" to GetReceipt.apiKey)

        val requestResult = Fuel.get("food/ingredients/$ingredientId/information/", parameters).awaitResult(
            moshiDeserializerOf(IngredientDto::class.java)
        )

        return requestResult.fold(success = {
            it
        }, failure = {
            throw ApiRequestException(it.message!!)
        })
    }
}