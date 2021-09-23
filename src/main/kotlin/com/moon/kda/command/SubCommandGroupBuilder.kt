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

import net.dv8tion.jda.api.interactions.commands.build.SubcommandData
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData
import net.dv8tion.jda.internal.utils.Checks

class SubCommandGroupBuilder {
  var name: String = "default"
    set(value) {
      Checks.notEmpty(name, "Name")
      Checks.notLonger(name, 32, "Name")
      Checks.matches(name, Checks.ALPHANUMERIC_WITH_DASH, "Name")
      Checks.isLowercase(name, "Name")
      field = value
    }
  var description: String = "default"
    set(value) {
      Checks.notEmpty(description, "Description")
      Checks.notLonger(description, 100, "Description")
      field = value
    }
  internal var subCommands = arrayOf<SubcommandData>()

  fun build(): SubcommandGroupData {
    return SubcommandGroupData(name, description)
      .addSubcommands(*subCommands)
  }
}