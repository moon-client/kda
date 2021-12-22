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

import com.moon.kda.entity.embed.EmbedBuilder
import net.dv8tion.jda.api.MessageBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.interactions.components.ActionRow

class MessageBuilder : MessageBuilder() {
    var tts = false
        set(tts) {
            setTTS(tts)
        }
    var nonce = ""
        set(nonce) {
            setNonce(nonce)
        }
    var content = ""
        set(content) {
            setContent(content)
        }

    fun embed(block: EmbedBuilder.() -> Unit) {
        setEmbeds(
            EmbedBuilder().apply(block)
                .build()
        )
    }

    fun actionRow(block: ActionRowBuilder.() -> Unit) {
        setActionRows(
            ActionRowBuilder().apply(block)
                .build()
        )
    }

    fun embeds(vararg embeds: MessageEmbed) {
        setEmbeds(*embeds)
    }

    fun actionRows(vararg actionRows: ActionRow) {
        setActionRows(*actionRows)
    }
}