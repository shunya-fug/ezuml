package com.dean.ezuml.controller

import com.dean.ezuml.common.interfaces.IPage
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

/**
 * 抽象Controller
 */
@Controller
abstract class AbstractController {

    /**
     * ページ遷移処理
     *
     * @param model Model
     * @param page ページ定義
     * @return 遷移先
     */
    fun move(model: Model, page: IPage): String {
        model.addAttribute("title", page.title)
        return page.url
    }

    /**
     * ページ遷移処理(forward)
     *
     * @param target 遷移先
     * @return 遷移先(forward)
     */
    fun forward(target: String) = "forward:$target"

}
