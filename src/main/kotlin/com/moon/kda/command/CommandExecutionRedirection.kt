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

import com.moon.kda.event.EventHook
import com.moon.kda.feature.Feature
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.commands.build.CommandData

class CommandExecutionRedirection : Feature() {
    private val redirections = hashMapOf<String, (SlashCommandInteractionEvent) -> Unit>()

    private val commandExecutionHook = EventHook<SlashCommandInteractionEvent> {
        val redirectionFunction = redirections[name] ?: return@EventHook
        redirectionFunction.invoke(this)
    }

    fun createRedirectionOf(
        commandData: CommandData,
        func: (SlashCommandInteractionEvent) -> Unit
    ) {
        redirections[commandData.name] = func
    }
}