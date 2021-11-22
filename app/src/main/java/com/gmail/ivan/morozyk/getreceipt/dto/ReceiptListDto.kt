package com.gmail.ivan.morozyk.getreceipt.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReceiptListDto(
    val results: List<ReceiptListItem>,
    val offset: Int,
    val number: Int,
    val totalResults: Int,
) {
    @JsonClass(generateAdapter = true)
    data class ReceiptListItem(val id: Int, val title: String, val image: String)
}