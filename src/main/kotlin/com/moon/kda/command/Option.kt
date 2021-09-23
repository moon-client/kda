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
package com.moon.kda.command

import com.moon.kda.failed
import net.dv8tion.jda.api.entities.GuildChannel
import net.dv8tion.jda.api.entities.IMentionable
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.interactions.commands.OptionType
import java.lang.Byte
import java.lang.Double
import java.lang.Float
import java.lang.Long
import java.lang.Short
import java.lang.IllegalArgumentException

private val optionTranslationMap = mapOf<Class<*>, OptionType>(
  String::class.java to OptionType.STRING,
  Integer::class.java to OptionType.INTEGER,
  Boolean::class.java to OptionType.BOOLEAN,
  User::class.java to OptionType.USER,
  GuildChannel::class.java to OptionType.CHANNEL,
  Role::class.java to OptionType.ROLE,
  IMentionable::class.java to OptionType.MENTIONABLE,
  Float::class.java to OptionType.NUMBER,
  Double::class.java to OptionType.NUMBER,
  Byte::class.java to OptionType.NUMBER,
  Long::class.java to OptionType.NUMBER,
  Short::class.java to OptionType.NUMBER
)

class Option<T>(
  private val genericType: Class<T>,
  val name: String,
  val description: String,
  val required: Boolean
) {
  fun discordOptionType(): OptionType {
    val translatedOption = optionTranslationMap[genericType] ?: run {
      failed("OptionType resolve error: $genericType does not have an assigned OptionType")
      throw IllegalArgumentException("Could not resolve an OptionType for $genericType")
    }
    return translatedOption
  }
}

inline fun <reified T> option(
  name: String,
  description: String,
  required: Boolean = false
): Option<T> {
  return Option(
    T::class.java,
    name,
    description,
    required
  )
}