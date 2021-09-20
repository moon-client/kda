# KDA
KDA is a compatibility layer for [JDA](https://github.com/DV8FromTheWorld/JDA) and Kotlin built for easy use of it with Kotlin

### This is still work in progress, therefore there is no maven repository. If you want to use this you have to build it yourself until it's stable.
## Events
### Hook events in KDA
```kotlin
class EventTest : Events() {
  val guildMessageReceivedHook = EventHook<GuildMessageReceivedEvent> {
    println("Received message: ${message.contentRaw}")
  }
}
```

### Register event listener classes in KDA
```kotlin
val token = "YOUR_TOKEN"
val jda = JDABuilder.createDefault(token).build()
jda.awaitReady()
jda.registerEvents(EventTest())
```

## Examples

### Create messages
```kotlin
message { 
  content = "This is an example message!"

  actionRow { 
    button {
      id = "example"
      label = "Example button"
      style = ButtonStyle.PRIMARY
    }
  }      
}
```
### Create embeds
```kotlin
embed {
  description = "Example description"
  thumbnail = "https://host.snens.team/i/cJpl1BCVLARV"
  image = "https://host.snens.team/i/cJpl1BCVLARV"
  title = "Example title"
  author {
    name = "Author example name"
    url = "https://github.com"
    iconUrl = "https://host.snens.team/i/cJpl1BCVLARV"
  }
  field {
    name = "Example field!"
    value = "Example value"
  }
  footer {
    text = "Example footer"
    iconUrl = "https://host.snens.team/i/cJpl1BCVLARV"
  }
  color {
    hex = 0xFFFFFF
  }
}
```
### Send messages in message channels
```
textChannel.sendMessage {
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
  }
```

<br>
TODO...
