package com.gmail.ivan.morozyk.getreceipt.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientDto(
    val aisle: String,
    val categoryPath: List<String>,
    val consistency: String,
    val id: Int,
    val image: String,
    val name: String,
    val original: String,
    val originalName: String,
    val possibleUnits: List<String>,
    val shoppingListUnits: List<String>
)