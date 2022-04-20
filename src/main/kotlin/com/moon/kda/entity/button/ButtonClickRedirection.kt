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
package com.moon.kda.entity.button

import com.moon.kda.event.EventHook
import com.moon.kda.feature.Feature
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent
import net.dv8tion.jda.internal.interactions.component.ButtonImpl

class ButtonClickRedirection : Feature() {
    private val redirections = hashMapOf<String, (ButtonInteractionEvent) -> Unit>()

    private val buttonClickHook = EventHook<ButtonInteractionEvent> {
        val clickedButton = button
        val redirectionFunction = redirections[clickedButton.id] ?: return@EventHook
        redirectionFunction.invoke(this)
    }

    fun createRedirectionOf(
        buttonImpl: ButtonImpl,
        func: (ButtonInteractionEvent) -> Unit
    ) {
        val buttonId = buttonImpl.id ?: run {
            throw IllegalArgumentException("You can't create a redirection for a button without an id!")
        }
        redirections[buttonId] = func
    }
}