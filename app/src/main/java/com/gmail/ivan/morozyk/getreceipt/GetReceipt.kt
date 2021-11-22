package com.gmail.ivan.morozyk.getreceipt

import android.util.Log
import com.github.kittinunf.fuel.core.FuelManager
import com.gmail.ivan.morozyk.getreceipt.exception.ApiNotInitializedException
import com.gmail.ivan.morozyk.getreceipt.service.IngredientService
import com.gmail.ivan.morozyk.getreceipt.service.IngredientServiceImpl
import com.gmail.ivan.morozyk.getreceipt.service.ReceiptService
import com.gmail.ivan.morozyk.getreceipt.service.ReceiptServiceImpl

object GetReceipt {

    private val TAG = GetReceipt::class.simpleName

    private var _apiKey: String? = null
    internal val apiKey: String
        get() {
            if (_apiKey == null)
                throw ApiNotInitializedException()
            else return _apiKey!!
        }

    fun init(apiKey: String) {
        FuelManager.instance.basePath = "https://api.spoonacular.com/"
        _apiKey = apiKey
        Log.d(TAG, "GetReceipt API initialized")
    }

    fun getReceiptService(): ReceiptService = ReceiptServiceImpl()

    fun getIngredientService(): IngredientService = IngredientServiceImpl()
}