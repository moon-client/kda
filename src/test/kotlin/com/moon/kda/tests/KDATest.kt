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

import com.moon.kda.entity.sendMessage
import com.moon.kda.event.registerEvents
import net.dv8tion.jda.api.JDABuilder
import java.io.File

fun main() {
  val token = File("token.txt")
  val jda = JDABuilder.createDefault(token.readText()).build()
  jda.awaitReady()
  val textChannel = jda.getGuildById("888493683131940894")
    ?.getTextChannelById("888914568108187779") ?: return
  textChannel.sendMessage({
    embed {
      description = "description test"
      title = "Title test"
      author {
        name = "Author example name"
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
  }, {
    println("sent message")
  })
  jda.registerEvents(EventTest())
}