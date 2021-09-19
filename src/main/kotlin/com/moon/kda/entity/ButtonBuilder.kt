/*
 * Copyright 2021 Moon Client
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
package com.moon.kda.entity

import net.dv8tion.jda.api.entities.Emoji
import net.dv8tion.jda.api.interactions.components.Button
import net.dv8tion.jda.api.interactions.components.ButtonStyle
import net.dv8tion.jda.internal.interactions.ButtonImpl
import net.dv8tion.jda.internal.utils.Checks

class ButtonBuilder {
  var id: String? = null
    set(id) {
      Checks.notEmpty(id, "ID")
      Checks.notLonger(id, Button.ID_MAX_LENGTH, "ID")
      field = id
    }
  var label: String? = null
    set(label) {
      Checks.notEmpty(label, "Label")
      Checks.notLonger(label, Button.LABEL_MAX_LENGTH, "Label")
      field = label
    }
  var style: ButtonStyle? = null
    set(style) {
      Checks.notNull(style, "Style")
      Checks.check(style != ButtonStyle.UNKNOWN, "Cannot make button with unknown style!")
      require(style != ButtonStyle.LINK || style == ButtonStyle.LINK) { "You cannot change a link button to another style!" }
      require(style == ButtonStyle.LINK || style != ButtonStyle.LINK) { "You cannot change a styled button to a link button!" }
      field = style
    }
  var url: String? = null
    set(url) {
      Checks.notEmpty(url, "URL")
      Checks.notLonger(url, Button.URL_MAX_LENGTH, "URL")
      field = url
    }
  var disabled = false
  var emoji: Emoji? = null

  fun build(): ButtonImpl {
    return ButtonImpl(
      id,
      label,
      style,
      url,
      disabled,
      emoji
    )
  }
}