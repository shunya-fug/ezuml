package com.dean.ezuml.controller.api

import org.springframework.security.web.csrf.CsrfToken
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 共通Controller
 */
@RestController
@RequestMapping("/api")
class CommonApiController {

    /**
     * CSRFトークン取得
     *
     * @param csrfToken CSRFトークン
     * @return CSRFトークン
     */
    @GetMapping("/csrf")
    fun getCsrfToken(csrfToken: CsrfToken) = csrfToken

}
