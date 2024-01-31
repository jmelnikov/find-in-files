package pw.mlnkv.scanner

import pw.mlnkv.result.ResultWriter
import java.io.File

class Scanner {
    private val filesPath = Settings.FILES_PATH
    private val resultWriter = ResultWriter()

    fun run() {
        println("Start scanning...")
        println("Walking filepath directory and counting files...")

        val files = File(filesPath).walk()
        val totalFiles = files.count()
        var filesCounter = 0

        println("Searching URLs in $totalFiles files...")

        files.forEach {
            // Increase files counter
            filesCounter++

            if(isExcludedFile(it.path) || it.isDirectory) {
                return@forEach
            }

            var linesCounter = 0
            it.readLines().forEach { line ->
                // Increase lines counter
                linesCounter++

                if(Regex(".*https?://.*").matches(line)) {
                    if(isExcludedLine(line.trim())) {
                        return@forEach
                    }

                    println("Found URL in ${it.path} ($filesCounter/$totalFiles)")

                    resultWriter.addLine(it.path, linesCounter, line.trim())
                }
            }
        }

        // Generate report
        resultWriter.generateReport()
    }

    private fun isExcludedFile(path: String): Boolean {
        val filesPath = Settings.FILES_PATH.replace("\\", "/")

        // Check if path is excluded
        val excludedPath = Settings.EXCLUDED_PATHS.any() {
            Regex("^$filesPath/$it(/.*)?$").matches(path)
        }

        // Check if file is excluded
        val excludedFile = Settings.EXCLUDED_FILES.any() {
            Regex("^$filesPath/$it$").matches(path)
        }

        // Check if file extension is excluded
        val excludedExtension = Settings.EXCLUDED_EXTENSION.any() {
            Regex("^$filesPath/(.*)\\.$it$").matches(path)
        }

        // Check if file path matches excluded regex
        val excludedRegex = Settings.EXCLUDED_PATH_REGEX.any() {
            it.matches(path)
        }

        return (excludedPath || excludedFile || excludedExtension || excludedRegex)
    }

    private fun isExcludedLine(line: String): Boolean {
        // Check if line matches excluded regex
        return Settings.EXCLUDED_LINES_REGEX.any() {
            it.matches(line)
        }
    }
}
