package pw.mlnkv.result

import pw.mlnkv.scanner.Settings
import java.io.File
import java.text.SimpleDateFormat

class ResultWriter {
    private val resultPath = Settings.RESULT_PATH
    private val resultFile = File("$resultPath/result.html")

    init {
        // Create result directory
        if (!File(resultPath).exists()) {
            File(resultPath).mkdir()
        }

        // Create temp directory
        if (!File("$resultPath/temp").exists()) {
            File("$resultPath/temp").mkdir()
        }

        // Clear result file
        resultFile.writeText("")
    }

    fun addLine(filename: String, lineNumber: Int, line: String) {
        val tempFilename = filename
            .replace(Settings.FILES_PATH, "")
            .replace("\\", "#")
            .replace("/", "#")
        val preparedLine = line
            .replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")

        if (!File("$resultPath/temp/$tempFilename").exists()) {
            File("$resultPath/temp/$tempFilename").writeText("")
        }

        File("$resultPath/temp/$tempFilename").appendText("<p>$lineNumber: $preparedLine</p>\n")
    }

    fun generateReport() {
        val tempFiles = File("$resultPath/temp").listFiles() ?: return
        println("Total files with URLs found: ${tempFiles.count()}")
        println("Generating report...")

        // Generate result file
        val header = this.javaClass.getResource("/result/header.html")?.readText()
            ?.replace("{{filesPath}}", Settings.FILES_PATH).toString()

        // Write header to result file
        resultFile.appendText("$header\n")

        // Blocks
        tempFiles.forEach { tempFile ->
            val filename = tempFile.name
                .replace("#", "/")

            val block = this.javaClass.getResource("/result/block.html")?.readText()
                ?.replace("{{filepath}}", filename)
                ?.replace("{{lines}}", tempFile.readLines().joinToString("\n"))

            resultFile.appendText("$block\n")
        }

        val footer = this.javaClass.getResource("/result/footer.html")?.readText()
            ?.replace("{{date}}", SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis()))
            ?.replace("{{time}}", SimpleDateFormat("HH:mm").format(System.currentTimeMillis())).toString()

        // Write footer to result file
        resultFile.appendText("$footer\n")

        // Clear temp directory
        println("Clearing temp directory...")
        tempFiles.forEach { tempFile ->
            tempFile.delete()
        }

        // Delete temp directory
        println("Deleting temp directory...")
        File("$resultPath/temp").delete()
    }
}
