# KDA
KDA is a compatibility layer for [JDA](https://github.com/DV8FromTheWorld/JDA) and Kotlin built for easy use of it with Kotlin

### This is still work in progress
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

<br>
TODO...
