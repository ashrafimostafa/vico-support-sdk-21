# Vico (minSdk 21)

A [Vico](https://github.com/patrykandpatrick/vico) chart-library fork that supports **Android API 21+**.

Upstream Vico 3.3.x requires a higher Android `minSdk` because it depends on Compose 1.10+. This fork is an **Android-only** build for apps on **Kotlin 1.9 / AGP 8.4 / compileSdk 35 / minSdk 21** (for example Imino).

Chart APIs stay the same as Vico Compose. Full chart docs: [Vico guide](https://guide.vico.patrykandpatrick.com).

**Author of this fork:** Mostafa Ashrafi  
**License:** Apache 2.0 (same as upstream Vico)

---

## Requirements

| Item | Value |
|------|--------|
| Android `minSdk` | 21 |
| Android `compileSdk` | **35+** (library `minCompileSdk` is 35) |
| Android Gradle Plugin | **8.4+** |
| Kotlin | **1.9.x** (library metadata is 1.9; does not require Kotlin 2.x) |
| Compose | Jetpack Compose via BOM **2024.12.01** (Compose Compiler **1.5.3**) |
| Repository | [JitPack](https://jitpack.io) |

---

## Installation (JitPack)

This is the usual way to use the library from another Android project.

### 1. Add JitPack

**settings.gradle.kts**

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
```

Groovy `build.gradle` (project or `allprojects`):

```groovy
repositories {
    google()
    mavenCentral()
    maven { url 'https://jitpack.io' }
}
```

### 2. Add the modules you need

**app/build.gradle.kts**

```kotlin
dependencies {
    implementation("com.github.ashrafimostafa.vico-support-sdk-21:compose:1.0.2")
    implementation("com.github.ashrafimostafa.vico-support-sdk-21:compose-m3:1.0.2")
    // Optional:
    // implementation("com.github.ashrafimostafa.vico-support-sdk-21:compose-m2:1.0.2")
    // implementation("com.github.ashrafimostafa.vico-support-sdk-21:compose-glance:1.0.2")
}
```

Groovy:

```groovy
dependencies {
    implementation 'com.github.ashrafimostafa.vico-support-sdk-21:compose:1.0.2'
    implementation 'com.github.ashrafimostafa.vico-support-sdk-21:compose-m3:1.0.2'
}
```

Use a [release tag](https://github.com/ashrafimostafa/vico-support-sdk-21/releases) as the version. The first JitPack download for a tag can take a few minutes.

| Module | Use it for |
|--------|------------|
| `compose` | Charts (required) |
| `compose-m3` | Material 3 colors (`rememberM3VicoTheme`) |
| `compose-m2` | Material 2 colors |
| `compose-glance` | Chart images in Glance widgets |

Package names are unchanged (`com.patrykandpatrick.vico.compose…`). Only the Maven coordinates differ.

---

## Other ways to consume the library

### Maven Local (this machine)

After `./gradlew :vico:compose:publishToMavenLocal :vico:compose-m3:publishToMavenLocal` in this repo:

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }
}

// app/build.gradle.kts — same implementation lines as JitPack
```

### Include this repo as source

In the **app** `settings.gradle.kts` (path relative to that app):

```kotlin
includeBuild("../vico-support-sdk-21") {
    dependencySubstitution {
        substitute(module("com.github.ashrafimostafa.vico-support-sdk-21:compose"))
            .using(project(":vico:compose"))
        substitute(module("com.github.ashrafimostafa.vico-support-sdk-21:compose-m3"))
            .using(project(":vico:compose-m3"))
    }
}
```

Keep the same `implementation("com.github.ashrafimostafa.vico-support-sdk-21:compose:1.0.2")` (and `-m3`) lines in the app module.

---

## Quick start (Compose)

```kotlin
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.compose.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.compose.cartesian.data.CartesianChartModelProducer
import com.patrykandpatrick.vico.compose.cartesian.data.lineModel
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.common.ProvideVicoTheme
import com.patrykandpatrick.vico.compose.m3.common.rememberM3VicoTheme

@Composable
fun SampleLineChart(modifier: Modifier = Modifier) {
    val modelProducer = remember { CartesianChartModelProducer() }
    LaunchedEffect(Unit) {
        modelProducer.runTransaction {
            lineModel { series(13, 8, 7, 12, 0, 1, 15, 14, 0, 11, 6, 12, 0, 11, 12, 11) }
        }
    }
    ProvideVicoTheme(rememberM3VicoTheme()) {
        CartesianChartHost(
            chart =
                rememberCartesianChart(
                    rememberLineCartesianLayer(),
                    startAxis = VerticalAxis.rememberStart(),
                    bottomAxis = HorizontalAxis.rememberBottom(),
                ),
            modelProducer = modelProducer,
            modifier = modifier,
        )
    }
}
```

Drop `SampleLineChart()` into a Compose screen. More chart types (columns, pie, combo, markers, zoom) are in `sample/` and in the [upstream guide](https://guide.vico.patrykandpatrick.com).

---

## Upstream

Based on [patrykandpatrick/vico](https://github.com/patrykandpatrick/vico) 3.3.1. Use this fork when you need **API 21**; use upstream Vico if your app already requires API 23/24+ and you want the newest Compose.
