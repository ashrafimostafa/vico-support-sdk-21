/*
 * Copyright 2026 by Patryk Goworowski and Patrick Michalik.
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

package com.patrykandpatrick.vico.compose.common.component

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

/**
 * Drop-shadow parameters for [ShapeComponent] / [LineComponent].
 *
 * This fork defines its own type so the library can compile against Compose 1.8 (AGP 8.4 /
 * compileSdk 35 consumers). Upstream Vico uses `androidx.compose.ui.graphics.shadow.Shadow`
 * from Compose 1.9+.
 */
@Immutable
public data class Shadow(
  public val radius: Dp = 0.dp,
  public val spread: Dp = 0.dp,
  public val color: Color = Color.Black.copy(alpha = 0.25f),
  public val offset: DpOffset = DpOffset.Zero,
)
