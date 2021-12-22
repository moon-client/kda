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

import com.moon.kda.entity.button.ButtonClickRedirection
import com.moon.kda.feature.Features
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.MessageChannel
import net.dv8tion.jda.api.events.interaction.ButtonClickEvent
import net.dv8tion.jda.internal.interactions.ButtonImpl
import java.util.function.Consumer

fun MessageChannel.sendMessage(block: MessageBuilder.() -> Unit) {
    this.sendMessage(
        MessageBuilder().apply(block)
            .build()
    ).queue()
}

fun MessageChannel.sendMessage(
    block: MessageBuilder.() -> Unit,
    consumer: Consumer<Message>
) {
    this.sendMessage(
        MessageBuilder().apply(block)
            .build()
    ).queue(consumer)
}

fun ButtonImpl.onClick(func: (ButtonClickEvent) -> Unit) {
    val clickRedirectionFeature = Features.BUTTON_CLICK_REDIRECTION.feature
            as ButtonClickRedirection
    clickRedirectionFeature.createRedirectionOf(
        this,
        func
    )
}