/*
 * Copyright 2025 by Patryk Goworowski and Patrick Michalik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins { id("com.vanniktech.maven.publish") }

mavenPublishing {
  pom {
    name.set("Vico (SDK 21)")
    description.set(
      "Vico chart library fork for Android minSdk 21, AGP 8.4, and Kotlin 1.9."
    )
    url.set("https://github.com/ashrafimostafa/vico-support-sdk-21")
    licenses {
      license {
        name.set("The Apache License, Version 2.0")
        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
      }
    }
    scm {
      connection.set("scm:git:git://github.com/ashrafimostafa/vico-support-sdk-21.git")
      developerConnection.set("scm:git:ssh://github.com/ashrafimostafa/vico-support-sdk-21.git")
      url.set("https://github.com/ashrafimostafa/vico-support-sdk-21")
    }
    developers {
      developer {
        id.set("ashrafimostafa")
        name.set("Mostafa Ashrafi")
      }
    }
  }
}
