package com.blr.project.utils

/**
 * Substitute values into request path.
 * Example: /users/{id} - after: /users/1
 */
fun convertPath(path: String, vararg args: Any): String {
    var regex = Regex("""\{[a-zA-Z0-9]+}""")
    var newPath = ""

    args.forEach {
        newPath = path.replaceFirst(regex, it.toString())
    }

    return newPath
}