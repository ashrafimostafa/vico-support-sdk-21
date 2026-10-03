---
metaLinks:
  alternates:
    - https://app.gitbook.com/s/Wpa2ykTaKZoySxzNtySN/getting-started
---

# Getting started

## Prerequisites

Ensure the following:

* JitPack is added to your project repositories.
* For Android, `minSdk` is set to at least 21 and `compileSdk` to at least 35.
* AGP 8.4+ is enough (this fork avoids Compose 1.9+ AAR metadata that requires AGP 8.6).

## Dependencies

Add only the modules you need. `compose-m2` and `compose-m3` provide Material 2 and Material 3 theming, respectively; `compose-glance` provides chart-image composables for Jetpack Glance app widgets.

**settings.gradle.kts**

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
```

**app/build.gradle.kts**

```kotlin
dependencies {
    implementation("com.github.ashrafimostafa.vico-support-sdk-21:compose:1.0.1")
    implementation("com.github.ashrafimostafa.vico-support-sdk-21:compose-m2:1.0.1")
    implementation("com.github.ashrafimostafa.vico-support-sdk-21:compose-m3:1.0.1")
    implementation("com.github.ashrafimostafa.vico-support-sdk-21:compose-glance:1.0.1")
}
```
