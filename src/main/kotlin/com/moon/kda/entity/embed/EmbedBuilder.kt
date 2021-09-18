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
package com.moon.kda.entity.embed

import com.moon.kda.entity.embed
import net.dv8tion.jda.api.EmbedBuilder

class EmbedBuilder : EmbedBuilder() {
  var description = ""
    set(value) {
      setDescription(value)
    }
  var thumbnail = ""
    set(value) {
      setThumbnail(value)
    }
  var image = ""
    set(value) {
      setImage(value)
    }

  fun author(block: EmbedAuthor.() -> Unit) {
    val embedAuthor = EmbedAuthor().apply(block)
    setAuthor(
      embedAuthor.name,
      embedAuthor.url,
      embedAuthor.iconUrl
    )
  }

  fun field(block: EmbedField.() -> Unit) {
    val embedField = EmbedField().apply(block)
    addField(
      embedField.name,
      embedField.value,
      embedField.inline
    )
  }

  fun footer(block: EmbedFooter.() -> Unit) {
    val embedFooter = EmbedFooter().apply(block)
    setFooter(
      embedFooter.text,
      embedFooter.iconUrl
    )
  }
}