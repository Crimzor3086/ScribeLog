# ScribeLog

ScribeLog is a unified Android toolkit designed to organize, monitor, and manage your device's apps, services, and logs in real-time. Built for developers, power users, and system maintainers, ScribeLog acts as the digital scribe for your Android environment — recording, alerting, and optimizing your device's performance with clarity and control.

## ✨ Core Features

- **📋 App Dashboard**
  - Centralized view of all installed apps
  - Launch, force-stop, uninstall, or inspect APK metadata
  - Real-time performance monitoring (CPU, RAM, storage usage per app)

- **⚙️ Service & Process Manager**
  - View all background services and system processes
  - Start/stop services with a single tap
  - Auto-monitor suspicious or battery-draining services
  - Set service priorities or restrictions

- **📚 Log Monitor & Viewer**
  - Live logcat stream with advanced filtering (by tag, PID, app name, level)
  - Search, bookmark, or export logs
  - Auto-detect crash logs and highlight stack traces
  - Timeline-based log navigation for event correlation

- **🛡️ App Behavior Analytics**
  - Track app permissions and recent activities
  - Monitor network activity, background syncs, and wake locks
  - Get alerts for high-resource usage or anomalous behavior

- **🔄 Automation & Task Rules (Optional Add-on)**
  - Create rules: "If X service crashes, restart it" or "If CPU > 80% for 5 mins, kill background apps"
  - Schedule log exports or app snapshots
  - Define smart triggers (e.g., "when launching Game A, disable Service B")

- **🌐 Network & Connectivity Insight**
  - Monitor live bandwidth usage by app or system component
  - Detect background data spikes
  - Log DNS queries and IP connections for transparency

- **🔔 Smart Notifications**
  - Get alerts for crashes, rogue services, permission misuse, or overheating
  - Summary reports for app behavior and system trends

- **🧠 AI Log Insight (Pro/Future Feature)**
  - Suggests probable causes of crashes based on log patterns
  - Recommends actions to resolve recurring issues
  - Highlights security risks (e.g., unknown services, root detection attempts)

- **📦 Optional Developer Mode Features**
  - ADB over WiFi integration
  - Export app logs and configurations to GitHub or local storage
  - Test intents, broadcast receivers, and background jobs
  - Visualize dependency graphs (apps → services → logs)

## 🗂️ Project Structure

- **📁 app/src/main/**
  - **✅ Entry Point & Core**
    - `MainActivity.kt` – Root dashboard/activity to host the app overview.
    - `ScribeLogApp.kt` – Application class (for initialization, logging, crash handlers).
    - `AndroidManifest.xml` – Declare permissions, services, app metadata.
  - **📁 ui/ — UI Components**
    - `DashboardFragment.kt` – Overview with system/app stats.
    - `AppManagerFragment.kt` – Installed apps, actions like uninstall, force stop.
    - `ServiceMonitorFragment.kt` – Running services & management tools.
    - `LogViewerFragment.kt` – Real-time logcat viewer with filters.
    - `SettingsFragment.kt` – Theme, preferences, automation rules.
    - `NotificationsFragment.kt` – Alert history and settings.
  - **📁 data/ — Data Handling**
    - `LogEntry.kt` – Data model for log events.
    - `AppInfo.kt` – App details (package, usage stats).
    - `ServiceInfo.kt` – Background service info.
    - `Rule.kt` – Custom rule or automation logic.
    - `Repository.kt` – Manages data sources (apps, logs, services).
  - **📁 utils/ — Utility & Helper Classes**
    - `LogcatHelper.kt` – Executes and parses logcat output.
    - `AppUtils.kt` – Gets installed apps, launch/stop logic.
    - `ServiceUtils.kt` – Background service monitoring helpers.
    - `PermissionHelper.kt` – Runtime permission handling.
    - `SystemStats.kt` – CPU, memory, and usage info.
    - `NotificationHelper.kt` – Builds smart alerts.
  - **📁 viewmodel/ — ViewModel Layer (using MVVM)**
    - `DashboardViewModel.kt`
    - `LogViewModel.kt`
    - `AppManagerViewModel.kt`
    - `ServiceMonitorViewModel.kt`
    - `SettingsViewModel.kt`
  - **📁 adapter/ — RecyclerView Adapters**
    - `LogAdapter.kt` – Displays logs.
    - `AppListAdapter.kt` – Installed app list.
    - `ServiceListAdapter.kt` – Running services.
    - `NotificationAdapter.kt` – Logged notifications/alerts.
  - **📁 res/values/**
    - `strings.xml` – UI strings and messages.
    - `colors.xml` – Theme colors (dark mode preferred).
    - `themes.xml` – App theme styles (Material 3 / Jetpack Compose if used).

## ⚙️ Root-Level Files

- `build.gradle` (project and app-level) – Include dependencies:
  ```kotlin
  implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0"
  implementation "androidx.recyclerview:recyclerview:1.3.2"
  implementation "androidx.navigation:navigation-fragment-ktx:2.7.7"
  implementation "com.google.android.material:material:1.12.0"
  ```
- `proguard-rules.pro` – (Optional) Obfuscation and log exceptions for release builds.

## 🛡️ Permissions You'll Likely Need in AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.PACKAGE_USAGE_STATS" tools:ignore="ProtectedPermissions"/>
<uses-permission android:name="android.permission.READ_LOGS"/>
<uses-permission android:name="android.permission.FOREGROUND_SERVICE"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.QUERY_ALL_PACKAGES" tools:ignore="QueryAllPackagesPermission" />
```

**Note:** For `READ_LOGS` and usage stats, you need root access or special access permission via UsageAccessSettings.

## 🧪 Optional Advanced Features

If you plan to implement automation and AI insights:

- `AutomationEngine.kt`
- `RuleEvaluator.kt`
- `CrashPredictor.kt` (basic ML or pattern matching for logs)
- `NetworkMonitor.kt` (for bandwidth & DNS tracking)

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details. 