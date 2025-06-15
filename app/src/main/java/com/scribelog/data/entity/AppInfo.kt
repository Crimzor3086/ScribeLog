package com.scribelog.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_info")
data class AppInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val packageName: String,
    val appName: String,
    val versionName: String?,
    val versionCode: Long?,
    val isSystemApp: Boolean = false,
    val installTime: Long?,
    val updateTime: Long?,
    val iconPath: String? = null,
    val cpuUsage: Float? = null,
    val ramUsage: Float? = null,
    val storageUsage: Long? = null
) 