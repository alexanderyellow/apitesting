package com.blr.project.model

import com.blr.project.utils.RandomUtils.randomString

//@Component
data class User constructor(var name: String? = null,
                var job: String? = null,
                var id: String? = null,
                var createdAt: String? = null,
                var updatedAt: String? = null) {

    constructor() : this(randomString("test#name"), randomString("test#job"), null, null)
}