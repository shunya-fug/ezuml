package com.dean.ezuml.controller

import com.dean.ezuml.common.enums.RelationEdgeType
import com.dean.ezuml.common.enums.RelationLineType
import com.dean.ezuml.common.interfaces.IPage
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

/**
 * PageController
 */
@Controller
class PageController : AbstractController() {

    /** ページ定義 */
    private enum class Page : IPage {
        /** Script入力画面 */
        SCRIPTS {
            override val title = "Script入力"
            override val url = "scripts/index"
        },

        /** ER図作成画面 */
        ER {
            override val title = "ER図作成"
            override val url = "er/index"
        }
    }

    /**
     * 初期表示
     *
     * @return Script入力画面
     */
    @GetMapping("/")
    fun index() = forward("/scripts")

    /**
     * Script入力画面
     *
     * @param model Model
     * @return Script入力画面
     */
    @GetMapping("/scripts")
    fun scripts(model: Model) = move(model, Page.SCRIPTS)

    /**
     * ER図作成画面
     *
     * @param model Model
     * @return ER図作成画面
     */
    @GetMapping("/er")
    fun er(model: Model): String {
        model.addAttribute("relationEdgeTypeEnum", RelationEdgeType.entries)
        model.addAttribute("relationLineTypeEnum", RelationLineType.entries)
        return move(model, Page.ER)
    }

}
