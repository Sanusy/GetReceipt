package com.gmail.ivan.morozyk.getreceipt.dto

import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
//data class SimilarReceiptsDto : ArrayList<SimilarReceiptsDto.SimilarReceiptsDtoItem>() {
//
//}

@JsonClass(generateAdapter = true)
data class SimilarReceiptsDtoItem(
    val id: Int,
    val imageType: String,
    val readyInMinutes: Int,
    val servings: Int,
    val sourceUrl: String,
    val title: String
)