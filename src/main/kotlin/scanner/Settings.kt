package pw.mlnkv.scanner

object Settings {
    const val FILES_PATH = "/files"
    const val RESULT_PATH = "/result"

    val EXCLUDED_PATHS = listOf(
        ".idea",
        ".git",
        "vendor",
        "docker",
        "data_mysql"
    )

    val EXCLUDED_FILES = listOf(
        ".env",
        ".env.dist",
        ".env.local",
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
        "scss",
        "sass",
        "less",
        "doc",
        "docx",
        "pdf",
        "xls",
        "xlsx",
        "ppt",
        "pptx",
        "odt",
        "ods",
        "odp",
        "odg",
        "odf",
        "txt",
        "csv",
        "ts",
        "tsx",
        "json",
        "yml",
        "yaml",
        "log",
        "sql",
        "sqlite",
        "sqlite3",
        "db",
        "sqlite-journal",
        "sqlite-shm",
        "sqlite-wal",
        "zip",
        "rar",
        "tar",
        "gz",
        "7z",
        "exe",
        "dll",
        "pkg",
        "jar",
        "war",
        "java",
        "class",
        "py",
        "pyc",
        "pyo",
        "pyd",
        "so",
        "dat",
        "bin",
        "dmg",
        "iso",
        "img",
        "apk",
        "data",
        "ttf",
        "ser",
        "sh",
        "rels",
        "md",
        "map",
        "lock",
        "min.js",
    )

    val EXCLUDED_LINES_REGEX = listOf(
        Regex("//.*"), // Single line comment
        Regex("#.*"), // Single line comment
        Regex("/.\\*.*"), // Multi line comment
        Regex("\\*.*") // Multi line comment
    )
}
