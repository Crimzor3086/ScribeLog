package com.scribelog

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.room.Room
import com.scribelog.data.AppDatabase
import com.scribelog.utils.CrashHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ScribeLogApp : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    
    // Database instance
    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "scribelog_database"
        ).build()
    }

    override fun onCreate() {
        super.onCreate()
        
        // Initialize crash handler
        CrashHandler.init(this)
        
        // Create notification channels
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // Log Monitor Channel
            val logChannel = NotificationChannel(
                CHANNEL_LOG_MONITOR,
                "Log Monitor",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications for log monitoring and alerts"
            }

            // App Monitor Channel
            val appChannel = NotificationChannel(
                CHANNEL_APP_MONITOR,
                "App Monitor",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Notifications for app monitoring and system events"
            }

            notificationManager.createNotificationChannels(listOf(logChannel, appChannel))
        }
    }

    companion object {
        const val CHANNEL_LOG_MONITOR = "log_monitor_channel"
        const val CHANNEL_APP_MONITOR = "app_monitor_channel"
    }
} 