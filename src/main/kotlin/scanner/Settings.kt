package pw.mlnkv.scanner

object Settings {
    const val FILES_PATH = "D:\\Projects\\kotlin\\find-urls-in-files"
    const val RESULT_PATH = "D:\\Projects\\kotlin\\find-urls-in-files\\docker\\result"

    val EXCLUDED_PATHS = listOf(
        ".idea",
        ".git",
        "vendor"
    )

    val EXCLUDED_FILES = listOf(
        ".env",
    )

    val EXCLUDED_EXTENSION = listOf(
        "mp3",
        "mp4",
        "avi",
        "mkv",
        "mov",
        "png",
        "jpg",
        "jpeg",
        "gif",
        "svg",
        "ico",
        "gitignore",
        "lock",
        "xml",
        "css",
        "scss"
    )

    val EXCLUDED_PATH_REGEX = listOf(
        Regex(".*min\\.js$"),
    )
}
