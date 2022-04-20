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

import com.moon.kda.entity.button.ButtonBuilder
import net.dv8tion.jda.api.interactions.components.ActionRow
import net.dv8tion.jda.api.interactions.components.Component
import net.dv8tion.jda.api.interactions.components.ItemComponent
import net.dv8tion.jda.internal.interactions.component.ButtonImpl

class ActionRowBuilder {
    private val components = mutableListOf<ItemComponent>()

    fun button(block: ButtonBuilder.() -> Unit): ButtonImpl {
        val button = ButtonBuilder().apply(block)
            .build()
        components.add(button)
        return button
    }

    fun build(): ActionRow {
        return ActionRow.of(components)
    }
}