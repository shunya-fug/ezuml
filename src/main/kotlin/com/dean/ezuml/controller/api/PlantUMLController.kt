package com.dean.ezuml.controller.api

import com.dean.ezuml.request.er.GetERImageRequest
import com.dean.ezuml.service.PlantUMLService
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 * PlantUML Controller
 *
 * @property plantUMLService PlantUML Service
 */
@Validated
@RestController
@RequestMapping("/api/uml")
class PlantUMLController(
    private val plantUMLService: PlantUMLService,
) {

    /**
     * Scriptから画像を生成して取得
     *
     * @param script PlantUML Script
     * @return 画像データ(Base64)
     */
    @PostMapping("/image", produces = [MediaType.IMAGE_PNG_VALUE])
    @ResponseBody
    fun getImageFromScript(@RequestBody script: String) = plantUMLService.getImageFromScript(script)

    /**
     * テーブル定義からER図を生成して取得
     *
     * @param request ER図取得Request
     * @return 画像データ(Base64)
     */
    @PostMapping("/image/er", produces = [MediaType.IMAGE_PNG_VALUE])
    @ResponseBody
    fun getImageFromER(@RequestBody @Validated request: GetERImageRequest) = plantUMLService.getImageFromER(request)

}
