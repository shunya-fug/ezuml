package com.dean.ezuml.request.er

import jakarta.validation.Valid
import jakarta.validation.constraints.NotEmpty

/**
 * ER図取得Request
 *
 * @property tableList テーブル定義リスト
 */
data class GetERImageRequest(

    @field:NotEmpty
    @field:Valid
    val tableList: List<TableDefinition>,

    )
