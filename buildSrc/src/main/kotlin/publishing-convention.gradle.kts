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
  val publishToCentral =
    project.hasProperty("mavenCentralUsername") ||
      System.getenv("ORG_GRADLE_PROJECT_mavenCentralUsername") != null

  // Maven Central + signing only when credentials are present (skip on JitPack/local).
  if (publishToCentral) {
    publishToMavenCentral(automaticRelease = true)
    signAllPublications()
  }

  pom {
    name = "Vico (SDK 21)"
    description =
      "A powerful and extensible multiplatform chart library, with Android minSdk 21 support."
    url = "https://github.com/ashrafimostafa/vico-support-sdk-21"
    licenses {
      license {
        name = "The Apache License, Version 2.0"
        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
      }
    }
    scm {
      connection = "scm:git:git://github.com/ashrafimostafa/vico-support-sdk-21.git"
      developerConnection = "scm:git:ssh://github.com/ashrafimostafa/vico-support-sdk-21.git"
      url = "https://github.com/ashrafimostafa/vico-support-sdk-21"
    }
    developers {
      developer {
        id = "ashrafimostafa"
        name = "Mostafa Ashrafi"
      }
      developer {
        id = "patrykgoworowski"
        name = "Patryk Goworowski"
        email = "contact@patrykgoworowski.pl"
      }
      developer {
        id = "patrickmichalik"
        name = "Patrick Michalik"
        email = "contact@patrickmichalik.com"
      }
    }
  }
}
