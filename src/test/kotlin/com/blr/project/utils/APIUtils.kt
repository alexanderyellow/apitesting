package com.blr.project.utils

fun convertPath(path: String, vararg args: Any): String {
    var regex = Regex("""\{[a-zA-Z0-9]+}""")
    var newPath = ""

    args.forEach {
        newPath = path.replaceFirst(regex, it.toString())
    }

    return newPath
}