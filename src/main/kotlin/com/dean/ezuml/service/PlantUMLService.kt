package com.dean.ezuml.service

import com.dean.ezuml.request.er.GetERImageRequest
import net.sourceforge.plantuml.FileFormat
import net.sourceforge.plantuml.FileFormatOption
import net.sourceforge.plantuml.SourceStringReader
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream
import java.util.*

/**
 * PlantUML Service
 */
@Service
class PlantUMLService {

    /**
     * Scriptから画像を生成して取得
     *
     * @param script PlantUML Script
     * @return 画像データ(Base64)
     */
    fun getImageFromScript(script: String): String {
        val reader = SourceStringReader(script.replace(";", "\n"))
        val os = ByteArrayOutputStream()
        reader.outputImage(os, FileFormatOption(FileFormat.PNG, false))
        return "data:image/png;base64," +  Base64.getEncoder().encodeToString(os.toByteArray())
    }

    /**
     * テーブル定義からER図を生成して取得
     *
     * @param request ER図取得Request
     * @return 画像データ(Base64)
     */
    fun getImageFromER(request: GetERImageRequest): String {
        val script = buildString {
            appendLine("@startuml")
            request.tableList.forEach { table ->
                appendLine(table.getScript())
            }
            request.tableList.forEach { table ->
                table.relationList?.forEach { relation ->
                    appendLine(relation.getScript())
                }
            }
            appendLine("@enduml")
        }
        val reader = SourceStringReader(script.replace(";", "\n"))
        val os = ByteArrayOutputStream()
        reader.outputImage(os, FileFormatOption(FileFormat.PNG, false))
        return "data:image/png;base64," +  Base64.getEncoder().encodeToString(os.toByteArray())
    }

}
