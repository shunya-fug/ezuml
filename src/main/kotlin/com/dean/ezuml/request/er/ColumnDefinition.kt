package com.dean.ezuml.request.er

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

/**
 * カラム定義
 *
 * @property name カラム名
 */
data class ColumnDefinition(

    @field:NotBlank
    @field:Size(max = 50)
    val name: String,

)
