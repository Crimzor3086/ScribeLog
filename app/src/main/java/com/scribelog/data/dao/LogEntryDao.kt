package com.scribelog.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.scribelog.data.entity.LogEntry

@Dao
interface LogEntryDao {
    @Query("SELECT * FROM log_entries ORDER BY timestamp DESC")
    fun getAllLogs(): LiveData<List<LogEntry>>

    @Query("SELECT * FROM log_entries WHERE isBookmarked = 1 ORDER BY timestamp DESC")
    fun getBookmarkedLogs(): LiveData<List<LogEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(log: LogEntry): Long

    @Update
    suspend fun update(log: LogEntry)

    @Delete
    suspend fun delete(log: LogEntry)

    @Query("DELETE FROM log_entries")
    suspend fun clearAll()
} 