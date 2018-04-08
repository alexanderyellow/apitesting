package com.blr.project.model

import com.blr.project.utils.RandomUtils.randomString

//@Component
class User {
    private var name: String
    private var job: String
    private var id: String? = null
    private var createdAt: String? = null
    private var updatedAt: String? = null

    constructor() {
        name = randomString("test#name")
        job = randomString("test#job")
    }

    fun setName(name: String): User {
        this.name = name
        return this
    }

    fun setJob(job: String): User {
        this.job = job
        return this
    }

    fun setId(id: String): User {
        this.id = id
        return this
    }

    fun setCreatedAt(createdAt: String): User {
        this.createdAt = createdAt
        return this
    }

    fun getName(): String {
        return name
    }

    fun getJob(): String {
        return job
    }

    fun getId(): String? {
        return id
    }

    fun getCreatedAt(): String? {
        return createdAt
    }

    fun setUpdatedAt(updatedAt: String): User {
        this.updatedAt = updatedAt
        return this
    }

    fun getUpdatedAt(): String? {
        return updatedAt
    }

    override fun toString(): String {
        return "name=$name, job=$job"
    }
}