package com.scribelog.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.scribelog.data.entity.ServiceInfo

@Dao
interface ServiceInfoDao {
    @Query("SELECT * FROM service_info ORDER BY serviceName ASC")
    fun getAllServices(): LiveData<List<ServiceInfo>>

    @Query("SELECT * FROM service_info WHERE isRunning = 1")
    fun getRunningServices(): LiveData<List<ServiceInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(service: ServiceInfo): Long

    @Update
    suspend fun update(service: ServiceInfo)

    @Delete
    suspend fun delete(service: ServiceInfo)

    @Query("DELETE FROM service_info")
    suspend fun clearAll()
} 