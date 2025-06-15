package com.scribelog.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.scribelog.data.dao.LogEntryDao
import com.scribelog.data.dao.AppInfoDao
import com.scribelog.data.dao.ServiceInfoDao
import com.scribelog.data.entity.LogEntry
import com.scribelog.data.entity.AppInfo
import com.scribelog.data.entity.ServiceInfo
import com.scribelog.data.util.Converters

@Database(
    entities = [
        LogEntry::class,
        AppInfo::class,
        ServiceInfo::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun logEntryDao(): LogEntryDao
    abstract fun appInfoDao(): AppInfoDao
    abstract fun serviceInfoDao(): ServiceInfoDao
} 