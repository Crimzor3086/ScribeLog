package com.scribelog.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "service_info")
data class ServiceInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val serviceName: String,
    val packageName: String,
    val isRunning: Boolean = false,
    val startTime: Long?,
    val cpuUsage: Float? = null,
    val ramUsage: Float? = null,
    val priority: Int? = null
) 