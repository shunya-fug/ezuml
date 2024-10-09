package com.dean.ezuml.common.enums

/**
 * リレーション線タイプ
 *
 * @property text 表示文字列
 * @property sign 記号
 */
enum class RelationLineType(
    val text: String,
    val sign: String,
) {

    LINE("直線", "-"),
    DASH("点線", "."),

}
