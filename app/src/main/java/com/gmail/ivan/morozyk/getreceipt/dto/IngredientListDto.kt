package com.gmail.ivan.morozyk.getreceipt.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientListDto(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
) {
    @JsonClass(generateAdapter = true)
    data class Result(
        val id: Int,
        val image: String,
        val name: String
    )
}