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
package com.moon.kda.tests

import com.moon.kda.entity.button
import com.moon.kda.entity.embed
import com.moon.kda.entity.message
import net.dv8tion.jda.api.entities.Emoji
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.interactions.components.ActionRow
import net.dv8tion.jda.api.interactions.components.ButtonStyle
import net.dv8tion.jda.internal.interactions.ButtonImpl

object EntityTests {
  fun testEmbedBuilder(): MessageEmbed {
    return embed {
      description = "description test"
      thumbnail = "https://host.snens.team/i/cJpl1BCVLARV"
      image = "https://host.snens.team/i/cJpl1BCVLARV"
      title = "Title test"
      author {
        name = "Author example name"
        url = "https://moonclient.xyz"
        iconUrl = "https://host.snens.team/i/cJpl1BCVLARV"
      }
      field {
        name = "Some field!"
        value = "Field value"
      }
      footer {
        text = "footer test"
      }
      color {
        hex = 0xFFFFFF
      }
    }
  }

  fun testButtonBuilder(): ButtonImpl {
    return button {
      id = "test"
      label = "Test button!"
      style = ButtonStyle.PRIMARY
      emoji = Emoji.fromUnicode("\uD83D\uDCE9")
    }
  }

  fun testMessageBuilder(): Message {
    return message {
      tts = false
      embeds(testEmbedBuilder())
      actionRows(ActionRow.of(testButtonBuilder()))
    }
  }
}