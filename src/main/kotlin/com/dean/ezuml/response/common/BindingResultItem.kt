package com.dean.ezuml.response.common

/**
 * BindingResult項目
 *
 * @property field エラー発生フィールド
 * @property message エラーメッセージ
 */
data class BindingResultItem(

    val field: String,

    val message: String,

)
