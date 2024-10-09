package com.dean.ezuml.request.er

import com.dean.ezuml.common.enums.RelationEdgeType
import com.dean.ezuml.common.enums.RelationLineType
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * リレーション定義
 *
 * @property from リレーション元
 * @property fromType リレーション元タイプ
 * @property to リレーション先
 * @property toType リレーション先タイプ
 * @property lineType 線タイプ
 * @property lineLength 長さ
 */
data class RelationDefinition(

    @field:NotBlank
    @field:Size(max = 50)
    val from: String,

    val fromType: RelationEdgeType,

    @field:NotBlank
    @field:Size(max = 50)
    val to: String,

    val toType: RelationEdgeType,

    val lineType: RelationLineType,

    @field:Min(1)
    @field:Max(5)
    val lineLength: Int,

    ) {

    fun getScript(): String {
        return "$from ${fromType.left}${lineType.sign.repeat(lineLength)}${toType.right} $to"
    }

}
