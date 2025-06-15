package com.scribelog.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.scribelog.data.entity.AppInfo

@Dao
interface AppInfoDao {
    @Query("SELECT * FROM app_info ORDER BY appName ASC")
    fun getAllApps(): LiveData<List<AppInfo>>

    @Query("SELECT * FROM app_info WHERE packageName = :packageName LIMIT 1")
    fun getAppByPackage(packageName: String): LiveData<AppInfo?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(app: AppInfo): Long

    @Update
    suspend fun update(app: AppInfo)

    @Delete
    suspend fun delete(app: AppInfo)

    @Query("DELETE FROM app_info")
    suspend fun clearAll()
} 