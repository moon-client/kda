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

import net.dv8tion.jda.api.JDABuilder
import java.io.File

fun main() {
  val token = File("token.txt")
  val build = JDABuilder.createDefault(token.readText()).build()
  build.awaitReady()
  build.getGuildById("888493683131940894")
    ?.getTextChannelById("888914568108187779")
    ?.sendMessage(EntityTests.testEmbedBuilder())
    ?.queue()
}