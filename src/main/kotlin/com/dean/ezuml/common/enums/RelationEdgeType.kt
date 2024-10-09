package com.dean.ezuml.common.enums

/**
 * リレーション端タイプ
 *
 * @property text 表示文字列
 * @property left 左端記号
 * @property right 右端記号
 */
enum class RelationEdgeType(
    val text: String,
    val left: String,
    val right: String,
) {

    /** 0 or 1 */
    ZERO_OR_ONE("0,1", "|o", "o|"),
    /** 1のみ */
    ONE("1", "||", "||"),
    /** 0以上 */
    GE_ZERO("0以上", "}o", "o{"),
    /** 1以上 */
    GE_ONE("1以上", "}|", "|{"),

}
