package com.dean.ezuml.request.er

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * テーブル定義
 *
 * @property name テーブル名
 * @property columnList カラム定義リスト
 * @property relationList リレーション定義リスト
 */
data class TableDefinition (

    @field:NotBlank
    @field:Size(max = 50)
    val name: String,

    @field:Valid
    val columnList: List<ColumnDefinition>,

    @field:Valid
    val relationList: List<RelationDefinition>?,

    ) {

    fun getScript(): String {
        return buildString {
            appendLine("entity $name {")
            columnList.forEach {
                appendLine("\t${it.name}")
            }
            appendLine("}")
        }
    }

}
