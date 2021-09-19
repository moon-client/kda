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
package com.moon.kda.event

import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.hooks.EventListener
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

open class Events : EventListener {
  private val listeners = hashMapOf<Type, MutableList<EventHook<GenericEvent>>>()

  override fun onEvent(event: GenericEvent) {
    val listeners = listeners[event.javaClass] ?: return
    listeners.forEach { listener ->
      listener.receiver.invoke(event)
    }
  }

  fun registerListeners() {
    javaClass.declaredFields.forEach { field ->
      if (field.type == EventHook::class.java) {
        field.isAccessible = true
        val parameterizedType = field.genericType as ParameterizedType
        val eventClazz = parameterizedType.actualTypeArguments[0]
        @Suppress("UNCHECKED_CAST")
        val eventHook = field[this] as? EventHook<GenericEvent> ?: run {
          println("Error while registering listener ${field.name}")
          return@forEach
        }
        val mutableList = listeners[eventClazz] ?: run {
          listeners[eventClazz] = mutableListOf(eventHook)
          return@forEach
        }
        mutableList.add(eventHook)
      }
    }
  }

}