package com.blr.project.model

import com.blr.project.utils.RandomUtils.randomString

//@Component
data class User(var name: String = randomString("test#name"),
                var job: String = randomString("test#job"),
                var id: String? = null,
                var createdAt: String? = null,
                var updatedAt: String? = null)