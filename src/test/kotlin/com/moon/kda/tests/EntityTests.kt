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

import com.moon.kda.entity.embed
import com.moon.kda.entity.message
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.MessageEmbed

object EntityTests {
  fun testEmbedBuilder(): MessageEmbed {
    return embed {
      description = "description test"
      thumbnail = "https://host.snens.team/i/cJpl1BCVLARV"
      image = "https://host.snens.team/i/cJpl1BCVLARV"
      title = "Title test"
      author {
        name = ""
        url = "https://moonclient.xyz"
        iconUrl = "https://moonclient.xyz"
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

  fun messageBuilderTest(): Message {
    return message {
    }
  }
}